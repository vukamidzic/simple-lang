#ifndef LIB_HPP
#define LIB_HPP

enum Types {
    INTEGER,// 0
    DOUBLE,// 1
    BOOL,// 2
    FUNC_END// 3
};

void print(enum Types type, ...);
void println(enum Types type, ...);

int maxValue(enum Types type, ...);

#endif
