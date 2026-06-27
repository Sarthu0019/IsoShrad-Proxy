package com.isoshrad.compiler;

import org.antlr.v4.runtime.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserValidationTest {

    @Test
    public void testValidSelectStatement() {
        String sql = "SELECT id, name FROM users WHERE id = 100";
        
        IsoShradSqlLexer lexer = new IsoShradSqlLexer(CharStreams.fromString(sql));
        IsoShradSqlParser parser = new IsoShradSqlParser(new CommonTokenStream(lexer));
        
        assertEquals(0, parser.getNumberOfSyntaxErrors(), "Parser should not throw syntax errors for valid SQL");
        
        IsoShradSqlParser.StatementContext root = parser.statement();
        assertNotNull(root.selectStatement(), "Root should contain a valid SELECT context");
    }
}