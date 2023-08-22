#ifndef LIB_HPP
#define LIB_HPP

enum Types {
    INTEGER,// 0
    DOUBLE,// 1
    BOOL,// 2
    FUNC_END// 3
};

//*********** PRINT FUNCTIONS ******************
void print(enum Types type, ...);
void println(enum Types type, ...);

//***** MATHEMATICAL FUNCTIONS *****************
int maxValue(enum Types type, ...);
int minValue(enum Types type, ...);
int gcd(enum Types type, ...);
int lcm(enum Types type, ...);
int mod(enum Types type, ...);

#endif
