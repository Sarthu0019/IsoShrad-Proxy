package com.isoshard.compiler;

import org.antlr.v4.runtime.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserValidationTest {

    @Test
    public void testValidSelectStatement() {
        String sql = "SELECT id, name FROM users WHERE id = 100";
        
        IsoShardSqlLexer lexer = new IsoShardSqlLexer(CharStreams.fromString(sql));
        IsoShardSqlParser parser = new IsoShardSqlParser(new CommonTokenStream(lexer));
        
        assertEquals(0, parser.getNumberOfSyntaxErrors(), "Parser should not throw syntax errors for valid SQL");
        
        IsoShardSqlParser.StatementContext root = parser.statement();
        assertNotNull(root.selectStatement(), "Root should contain a valid SELECT context");
    }
}