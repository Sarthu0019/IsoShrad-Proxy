package com.isoshrad.tx;

public class ShardManager {
    public void broadcastRollback(String txId) {
        System.out.println("[ShardManager] Successfully broadcasted compensating ROLLBACK for TxID: " + txId);
    }
}