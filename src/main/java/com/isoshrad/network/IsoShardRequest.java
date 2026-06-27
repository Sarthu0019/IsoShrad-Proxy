package com.isoshrad.network;

public class IsoShardRequest {
    private final byte commandType;
    private final String sqlQuery;

    public IsoShardRequest(byte commandType, String sqlQuery) {
        this.commandType = commandType;
        this.sqlQuery = sqlQuery;
    }

    public byte getCommandType() { return commandType; }
    public String getSqlQuery() { return sqlQuery; }
}