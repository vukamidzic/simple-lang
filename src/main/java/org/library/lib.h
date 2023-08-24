#ifndef LIB_HPP
#define LIB_HPP

enum Types {
    INTEGER,
    DOUBLE,
    BOOL,
    PTR,
    FUNC_END
};

//*********** PRINT FUNCTIONS ******************
void print(enum Types type, ...);
void println(enum Types type, ...);

//*********** INPUT FUNCTIONS ******************
void input(enum Types type, ...);

//***** MATHEMATICAL FUNCTIONS *****************
int maxValue(enum Types type, ...);
int minValue(enum Types type, ...);
int gcd(enum Types type, ...);
int lcm(enum Types type, ...);
int mod(enum Types type, ...);

#endif
