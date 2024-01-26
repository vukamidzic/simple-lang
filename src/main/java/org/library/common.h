#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#ifndef COMMON_H
#define COMMON_H

typedef enum Types {
    INTEGER = 0,
    DOUBLE = 1,
    BOOL = 2,
    CHAR = 3,
    INT_PTR = 4,
    FLOAT_PTR = 5,
    ARRAY = 6,
    STRING = 7,
    FUNC_END = 8
} Types;

static inline char* type_to_str(Types type) {
    switch (type) {
        case INTEGER : {
            return "INT";
        }
        case DOUBLE : {
            return "FLOAT";
        }
        case BOOL : {
            return "BOOL";
        }
        case CHAR : {
            return "CHAR";
        }
        case INT_PTR : {
            return "INT*";
        }
        case FLOAT_PTR : {
            return "FLOAT*";
        }
        case ARRAY : {
            return "ARRAY";
        }
        case STRING : {
            return "STRING";
        }
        default : {
            return "UNDEFINED";
        }
    }
}

typedef struct Array {
    long long data;
    void* elems;
} Array;

#endif