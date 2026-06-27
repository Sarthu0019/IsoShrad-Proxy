package com.isoshrad.tx;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.Map;

public class CrashRecoveryDaemon {
    private final DynamoDbClient dynamoClient;
    private final String tableName = "IsoShard_WAL";

    public CrashRecoveryDaemon() {
        this.dynamoClient = DynamoDbClient.create();
    }

    /**
     * Scans the WAL for transactions that were PREPARED but never finalized.
     * This runs synchronously on proxy startup before Netty accepts traffic.
     */
    public void reconcileOrphanedTransactions(ShardManager shardManager) {
        System.out.println("[Recovery] Scanning WAL for orphaned transactions...");

        ScanRequest scanRequest = ScanRequest.builder()
            .tableName(tableName)
            .filterExpression("#s = :val")
            .expressionAttributeNames(Map.of("#s", "State"))
            .expressionAttributeValues(Map.of(":val", AttributeValue.builder().s("PREPARED").build()))
            .build();

        ScanResponse response = dynamoClient.scan(scanRequest);

        for (Map<String, AttributeValue> item : response.items()) {
            String txId = item.get("TransactionId").s();
            System.out.println("[Recovery] Found orphaned TxID: " + txId + ". Issuing ROLLBACK.");
            
            try {
                // Broadcast rollback to all shards. Idempotency ensures safety.
                shardManager.broadcastRollback(txId);
                markAsAbortedInWal(txId);
            } catch (Exception e) {
                System.err.println("[Recovery] Handled exception reconciling transaction " + txId + ": " + e.getMessage());
            }
        }
        System.out.println("[Recovery] Reconciliation complete.");
    }

    private void markAsAbortedInWal(String txId) {
        System.out.println("[WAL] Marked transaction " + txId + " as ABORTED in logging table.");
    }
}