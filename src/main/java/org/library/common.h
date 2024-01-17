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
    FUNC_END = 7
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
        default : {
            return "UNDEFINED";
        }
    }
}

static inline char* get_filename(char* path) {
    char* file = strrchr(path, '/');
    return file+1;
}

typedef struct Array {
    long long data;
    void* elems;
} Array;

#endif