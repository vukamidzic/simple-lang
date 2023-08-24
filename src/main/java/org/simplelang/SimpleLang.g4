grammar SimpleLang;

WHILE : 'while';
FOR : 'for';
PTR : 'ptr';

TRUE : 'true';
FALSE : 'false';

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
    | statFuncCall # ToFuncCall
    | whileStmt # ToWhile
    | forStmt #ToFor
    | ifElseStmt # ToIfElse
    | block_of_stmts # ToBlock
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
    : mulOrDiv MUL atom # Mul
    | mulOrDiv DIV atom # Div
    | ptrOp # ToPtr 
;

ptrOp 
    : PTR LPAR atom RPAR # ToPointer
    | '*' atom  # FromPointer
    | atom # ToAtom
;

atom
    : bool # ToBool
    | exprFuncCall # ToExprFuncCall
    | INT # Integer
    | FLOAT # Float
    | ID # Variable
    | LPAR logical RPAR # Parens
;

exprFuncCall
    : ID LPAR expr (COMMA expr)* RPAR # EFuncCall
;

bool
    : TRUE # True
    | FALSE # False
;
