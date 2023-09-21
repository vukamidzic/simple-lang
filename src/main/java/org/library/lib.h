#ifndef LIB_HPP
#define LIB_HPP

typedef enum Types {
    INTEGER,
    DOUBLE,
    BOOL,
    PTR,
    ARRAY,
    FUNC_END
} Types;

typedef struct Array {
    int* elems;
    int size;
} Array;

//*********** PRINT FUNCTIONS ******************
void print(Types type, ...);
void println(Types type, ...);

//*********** INPUT FUNCTIONS ******************
void input(Types type, ...);

//***** MATHEMATICAL FUNCTIONS *****************
int maxValue(Types type, ...);
int minValue(Types type, ...);
int gcd(Types type, ...);
int lcm(Types type, ...);
int mod(Types type, ...);
double sini(Types type, ...);
double cosi(Types type, ...);

//***** ARRAY FUNCTIONS *****************
Array newArray(Types type, ...);
int arrayGet(Types type, ...);
int arrayLen(Types type, ...);

#endif
