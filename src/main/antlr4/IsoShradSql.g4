grammar IsoShardSql;

// ===== PARSER RULES (Abstract Syntax Tree Nodes) =====

statement
    : selectStatement EOF
    | insertStatement EOF
    | updateStatement EOF
    ;

selectStatement
    : SELECT columnList FROM tableName (WHERE condition)?
    ;

insertStatement
    : INSERT INTO tableName '(' columnList ')' VALUES '(' valueList ')'
    ;

updateStatement
    : UPDATE tableName SET assignmentList WHERE condition
    ;

columnList
    : IDENTIFIER (',' IDENTIFIER)*
    | '*'
    ;

valueList
    : expression (',' expression)*
    ;

assignmentList
    : assignment (',' assignment)*
    ;

assignment
    : IDENTIFIER EQ expression
    ;

tableName
    : IDENTIFIER
    ;

condition
    : expression
    ;

expression
    : left=expression operator=(EQ | NEQ | GT | LT | GTE | LTE) right=expression
    | IDENTIFIER
    | STRING_LITERAL
    | NUMERIC_LITERAL
    ;

// ===== LEXER RULES (Tokenization) =====

SELECT  : [sS] [eE] [lL] [eE] [cC] [tT];
FROM    : [fF] [rR] [oO] [mM];
WHERE   : [wW] [hH] [eE] [rR] [eE];
INSERT  : [iI] [nN] [sS] [eE] [rR] [tT];
INTO    : [iI] [nN] [tT] [oO];
VALUES  : [vV] [aA] [lL] [uU] [eE] [sS];
UPDATE  : [uU] [pP] [dD] [aA] [tT] [eE];
SET     : [sS] [eE] [tT];

EQ  : '=';
NEQ : '<>' | '!=';
GT  : '>';
LT  : '<';
GTE : '>=';
LTE : '<=';

IDENTIFIER      : [a-zA-Z] [a-zA-Z0-9_]*;
STRING_LITERAL : '\'' (~[']* | '\'\'')* '\'';
NUMERIC_LITERAL: [0-9]+ ('.' [0-9]+)?;

WS : [ \t\r\n]+ -> skip;