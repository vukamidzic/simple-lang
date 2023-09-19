#ifndef LIB_HPP
#define LIB_HPP

typedef enum Types {
    INTEGER,
    DOUBLE,
    BOOL,
    PTR,
    FUNC_END
} Types;

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

#endif
