#ifndef LIB_HPP
#define LIB_HPP

typedef enum Types {
    INTEGER,
    DOUBLE,
    BOOL,
    CHAR,
    PTR,
    ARRAY,
    FUNC_END
} Types;

typedef struct Array {
    long long data;
    void* elems;
} Array;

//*********** PRINT FUNCTIONS ******************
void print(Types type, ...);

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
Array array(Types type, ...);
int elemType(Types type, ...);
int len(Types type, ...);
void put(Types type, ...);
int geti(Types type, ...);
double getf(Types type, ...);

#endif
