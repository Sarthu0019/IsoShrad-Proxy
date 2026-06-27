package com.isoshrad.tx;

import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class DynamoDbWalLogger {
    private final DynamoDbAsyncClient dynamoClient;
    private final String tableName = "IsoShard_WAL";

    public DynamoDbWalLogger() {
        this.dynamoClient = DynamoDbAsyncClient.create();
    }

    /**
     * Asynchronously logs the transaction state to AWS DynamoDB.
     * This MUST complete before Phase 2 dispatch to ensure crash recoverability.
     */
    public CompletableFuture<Void> logTransactionState(String txId, String state) {
        Map<String, AttributeValue> item = Map.of(
            "TransactionId", AttributeValue.builder().s(txId).build(),
            "State", AttributeValue.builder().s(state).build(),
            "Timestamp", AttributeValue.builder().n(String.valueOf(System.currentTimeMillis())).build()
        );

        PutItemRequest request = PutItemRequest.builder()
            .tableName(tableName)
            .item(item)
            .build();

        return dynamoClient.putItem(request).thenApply(response -> null);
    }
}