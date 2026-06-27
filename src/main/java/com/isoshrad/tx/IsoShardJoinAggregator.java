package com.isoshrad.tx;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class IsoShardJoinAggregator {

    // Simulates an asynchronous database query execution pool over network sockets
    private CompletableFuture<List<Map<String, Object>>> asyncQuery(String shard, String query) {
        return CompletableFuture.supplyAsync(() -> {
            // Mock network round-trip delay fetching rows from physical RDS nodes
            try { Thread.sleep(15); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            
            List<Map<String, Object>> mockResultSet = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                Map<String, Object> row = new HashMap<>();
                row.put("id", i);
                row.put("shard_source", shard);
                row.put("payload_data", "Data_From_" + shard + "_Row_" + i);
                mockResultSet.add(row);
            }
            return mockResultSet;
        });
    }

    /**
     * Executes queries on two different shards asynchronously and performs
     * an in-memory Hash Join on the specified join column.
     */
    public CompletableFuture<List<Map<String, Object>>> executeDistributedJoin(
            String shardA, String queryA, String joinColA,
            String shardB, String queryB, String joinColB,
            ShardManager manager) {
            
        System.out.println("[JoinEngine] Initializing parallel cross-shard network broadcast fetch...");
        
        // Fire both network requests in parallel using non-blocking NIO threads
        CompletableFuture<List<Map<String, Object>>> futureA = asyncQuery(shardA, queryA);
        CompletableFuture<List<Map<String, Object>>> futureB = asyncQuery(shardB, queryB);

        // Chain the futures together to execute an in-memory classic Hash Join once both arrive
        return futureA.thenCombine(futureB, (resultSetA, resultSetB) -> {
            System.out.println("[JoinEngine] Both payloads received. Building hash lookup table index...");
            
            // Phase 1: Build the Hash Map from the smaller localized result set (Set B)
            Map<Object, Map<String, Object>> hashIndex = resultSetB.stream()
                .collect(Collectors.toMap(
                    row -> row.get(joinColB), 
                    row -> row,
                    (existing, replacement) -> existing // Merge function to handle potential duplicate keys safely
                ));

            List<Map<String, Object>> joinedResults = new ArrayList<>();

            // Phase 2: Probe the compiled Hash Map using the rows from Set A
            System.out.println("[JoinEngine] Probing hash index using primary record dataset streams...");
            for (Map<String, Object> rowA : resultSetA) {
                Object joinValue = rowA.get(joinColA);
                if (hashIndex.containsKey(joinValue)) {
                    // Merge properties from both shard payloads into a single structural block
                    Map<String, Object> combinedRow = new HashMap<>(rowA);
                    combinedRow.putAll(hashIndex.get(joinValue));
                    joinedResults.add(combinedRow);
                }
            }
            
            System.out.println("[JoinEngine] Multi-shard execution merge phase finalized. Total records: " + joinedResults.size());
            return joinedResults;
        });
    }
}