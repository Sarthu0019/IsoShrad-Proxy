package com.isoshrad.compiler;

public class ParsedQueryPlan {
    public enum QueryType { READ, WRITE }
    
    private final QueryType type;
    private String tableName;
    private String routingKey;

    public ParsedQueryPlan(QueryType type) {
        this.type = type;
    }

    public QueryType getType() { return type; }
    public String getTableName() { return tableName; }
    public void setTableName(String tableName) { this.tableName = tableName; }
    public String getRoutingKey() { return routingKey; }
    public void setRoutingKey(String routingKey) { this.routingKey = routingKey; }
}