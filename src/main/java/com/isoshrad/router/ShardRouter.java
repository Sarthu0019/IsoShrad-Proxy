package com.isoshrad.router;

import java.nio.charset.StandardCharsets;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class ShardRouter {
    @SuppressWarnings("deprecation")
    private final HashFunction hashFunction = Hashing.murmur3_32();
    private final SortedMap<Integer, String> hashRing = new TreeMap<>();
    private final int VIRTUAL_NODES = 100;

    // Initialize the cluster topology
    public void addPhysicalShard(String rdsEndpoint) {
        for (int i = 0; i < VIRTUAL_NODES; i++) {
            String virtualNodeName = rdsEndpoint + "-VN" + i;
            int hash = hashFunction.hashString(virtualNodeName, StandardCharsets.UTF_8).asInt();
            hashRing.put(hash, rdsEndpoint);
        }
    }

    // Map a parsed AST routing key to a specific physical shard
    public String routeQuery(String routingKey) {
        if (hashRing.isEmpty()) {
            throw new IllegalStateException("Cluster topology is empty. No shards available.");
        }

        int queryHash = hashFunction.hashString(routingKey, StandardCharsets.UTF_8).asInt();

        // Find the next node on the consistent hash ring
        SortedMap<Integer, String> tailMap = hashRing.tailMap(queryHash);
        int nodeHash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();

        return hashRing.get(nodeHash);
    }
}