grammar SimpleLang;

WHILE : 'while';

TRUE : 'true';
FALSE : 'false';

EQ : ':=';
DSEMIC : '::';
PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';

LESS : '<';
GREAT : '>';
CMP_EQ : '=';
CMP_NEQ : '/=';

AND : 'and';
OR : 'or';
NOT : 'not';

LPAR : '(';
RPAR : ')';
LCURL : '{';
RCURL : '}';
QMARK : '?';
COMMA : ',';

WS : ([ \t\r] | [ \t]) -> skip;
NL : ('\r\n' | '\n') -> skip;

INT : '-'?[0-9]+;
FLOAT : '-'? INT '.' INT;
ID : ('_')?[a-zA-Z]+;

program
    : statements # ToStatements
    | EOF # EndOfProgram
;

statements
    : statement statements # MultipleStat
    | statement # SingleStat
;

statement
    : assignment # ToAssignment
    | funcCall # ToFuncCall
    | whileStmt # ToWhile
    | ifElseStmt # ToIfElse
    | block_of_stmts # ToBlock
;

ifElseStmt
    : LPAR expr RPAR QMARK block_of_stmts # NonEmptyIf
    | LPAR RPAR QMARK block_of_stmts # EmptyIf
;

whileStmt
    : WHILE LPAR expr RPAR block_of_stmts
;

block_of_stmts
    : LCURL statements RCURL # Block
;

assignment
    : ID EQ expr # AssignVar
    | ID DSEMIC expr # AssignConst
;

funcCall
    : ID LPAR expr (COMMA expr)* RPAR # FunctionCall
;

expr
    : logical # Expression
;

logical
    : logical AND compare # And
    | logical OR compare # Or
    | compare # ToCompare
;

compare
    : compare LESS plusOrMinus # Less
    | compare GREAT plusOrMinus # Great
    | compare CMP_EQ plusOrMinus # Eq
    | compare CMP_NEQ plusOrMinus # Neq
    | plusOrMinus # ToPlusOrMinus
;

plusOrMinus
    : plusOrMinus PLUS mulOrDiv # Plus
    | plusOrMinus MINUS mulOrDiv # Minus
    | mulOrDiv # ToMulOrDiv
;

mulOrDiv
    : mulOrDiv MUL atom # Mul
    | mulOrDiv DIV atom # Div
    | atom # ToAtom
;

atom
    : bool # ToBool
    | INT # Integer
    | FLOAT # Float
    | ID # Variable
    | LPAR logical RPAR # Parens
;

bool
    : TRUE # True
    | FALSE # False
;
