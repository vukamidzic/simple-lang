grammar SimpleLang;

WHILE : 'while';
FOR : 'for';
PTR : '@';

TRUE : 'true';
FALSE : 'false';

TYPE : 'int'|'float'|'bool'|'char'|'Array'|'void';

EQ : ':=';
DSEMIC : '::';
PLUS : '+';
MINUS : '-';
MUL : '*';
DIV : '/';
LARROW : '<-';

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
CHAR : '\''[0-9a-zA-Z]'\'';
ID : ('_')?[a-zA-Z]+;
STR : '"'(.*?)'"';

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
    | statFuncCall # ToFuncCall
    | whileStmt # ToWhile
    | forStmt # ToFor
    | ifElseStmt # ToIfElse
    | block_of_stmts # ToBlock
    | functionDef # ToFuncDef
    | functionExit # ToReturn
;

ifElseStmt
    : LPAR expr RPAR QMARK block_of_stmts # NonEmptyIf
    | LPAR RPAR QMARK block_of_stmts # EmptyIf
;

forStmt
    : FOR LPAR ID LARROW expr ',' expr RPAR block_of_stmts
;

whileStmt
    : WHILE LPAR expr RPAR block_of_stmts
;

block_of_stmts
    : LCURL statements RCURL # Block
;

functionDef 
    : 'proc' ID LPAR (ID TYPE)?(',' ID TYPE)* RPAR TYPE block_of_stmts # FuncDef
;

functionExit
    : 'ret' expr # Return
;

assignment
    : ID EQ expr # AssignVar
    | ID DSEMIC expr # AssignConst
;

statFuncCall
    : ID LPAR expr (COMMA expr)* RPAR # SFuncCall
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
    : mulOrDiv MUL pointer # Mul
    | mulOrDiv DIV pointer # Div
    | pointer # ToPointer
;

pointer : PTR atom #Ptr
        | atom #ToAtom
;

atom
    : bool # ToBool
    | exprFuncCall # ToExprFuncCall
    | INT # Integer
    | FLOAT # Float
    | ID # Variable
    | CHAR # Character
    | STR # String
    | LPAR logical RPAR # Parens
;

exprFuncCall
    : ID LPAR expr (COMMA expr)* RPAR # EFuncCall
;

bool
    : TRUE # True
    | FALSE # False
;
