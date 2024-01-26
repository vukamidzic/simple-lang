#include "config.h"
#include "common.h"

#include <stdio.h> 
#include <stdlib.h>
#include <stdbool.h>
#include <stdarg.h>
#include <stdint.h>
#include <string.h>

#ifndef S_ARRAYS_H
#define S_ARRAYS_H

#ifdef ARRAYS

Array array(Types type, ...) {
    va_list args;
    va_start(args, type);

    int size = va_arg(args, int);
    if (size < 1) {
        fprintf(stderr, "[\033[35m%s\033[0m] %s(): Array size should be greater or equal to 1\n", 
            __FILE__,
            __func__
        );
        exit(EXIT_FAILURE);
    }

    type = va_arg(args, Types);
    Array arr;

    arr.data = (type << 16) | size;

    switch (type) {
        case INTEGER : {
            int elem = va_arg(args, int);
            arr.elems = (int*)malloc(size*sizeof(int));
            
            for (int i = 0; i < size; ++i) {
                ((int*)arr.elems)[i] = elem;
            }   
            break;
        }
        case DOUBLE : {
            double elem = va_arg(args, double);
            arr.elems = (double*)malloc(size*sizeof(double));
            
            for (int i = 0; i < size; ++i) {
                ((double*)arr.elems)[i] = elem;
            }
            break;
        }
        case BOOL : {
            bool elem = va_arg(args, bool);
            arr.elems = (bool*)malloc(size*sizeof(bool));
            
            for (int i = 0; i < size; ++i) {
                ((bool*)arr.elems)[i] = elem;
            }
            break;
        }
        default : {
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected INT|FLOAT|BOOL, got %s\n", 
                __FILE__,
                __func__, 
                type_to_str(type)
            );
            exit(EXIT_FAILURE);
        }
    }

    return arr;
}

Array arrayFrom(Types type, ...) {
    va_list args;
    va_start(args, type);

    Array arr;
    Types arr_type = type;
    int pos = 0, cnt = 0;

    switch (arr_type) {
        case INTEGER : {
            arr.elems = (int*)malloc(sizeof(int));
            ((int*)arr.elems)[pos++] = va_arg(args, int); 
            break;
        }
        case DOUBLE : {
            arr.elems = (double*)malloc(sizeof(double));
            ((double*)arr.elems)[pos++] = va_arg(args, double);
            break;
        }
        case BOOL : {
            arr.elems = (bool*)malloc(sizeof(bool));
            ((bool*)arr.elems)[pos++] = va_arg(args, bool);
            break;
        }
        case ARRAY : {
            Array a = va_arg(args, Array);
            memcpy(arr.elems, a.elems, a.data & (((1 << 16) - 1)));
            arr.data = a.data;
            return arr;
        }
    }

    type = va_arg(args, Types);

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER : {
                arr.elems = (int*)realloc(arr.elems, sizeof(int)); 
                cnt++;
                ((int*)arr.elems)[pos++] = va_arg(args, int);
                break;
            }
            case DOUBLE : {
                arr.elems = (double*)realloc(arr.elems, sizeof(double));
                cnt++;
                ((double*)arr.elems)[pos++] = va_arg(args, double);
                break;
            }
            case BOOL : {
                arr.elems = (bool*)realloc(arr.elems, sizeof(bool));
                cnt++;
                ((bool*)arr.elems)[pos++] = va_arg(args, bool);
                break;
            }
        }
        type = va_arg(args, Types);
    }

    arr.data = (arr_type << 16) | (cnt+1);
    return arr;
}

int elemType(Types type, ...) { 
    va_list args;
    va_start(args, type);

    if (type != ARRAY) {
        fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected ARRAY, got %s\n", 
            __FILE__,
            __func__, 
            type_to_str(type)
        );
        exit(EXIT_FAILURE);
    }
    else {
        Array arr = va_arg(args, Array);
        uint32_t ty = arr.data >> 16;
        return ty;
    }
}

int len(Types type, ...) {
    va_list args;
    va_start(args, type);

    switch (type) {
        case ARRAY : {
            Array arr = va_arg(args, Array);
            return arr.data & (((1 << 16) - 1)); 
        }
        default : {
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected ARRAY, got %s\n", 
                __FILE__,
                __func__, 
                type_to_str(type)
            );
            exit(EXIT_FAILURE);
        }
    }
}

void put(Types type, ...) {
    va_list args;
    va_start(args, type);

    switch (type) {
        case ARRAY : {
            Array arr = va_arg(args, Array);
            type = va_arg(args, Types);
            int index = va_arg(args, int);
            type = va_arg(args, Types);

            switch (type) {
                case INTEGER : {
                    int x = va_arg(args, int);
                    ((int*)arr.elems)[index] = x;
                    return;    
                }
                case DOUBLE : {
                    double x = va_arg(args, double);
                    ((double*)arr.elems)[index] = x;
                    return;    
                }
                case BOOL : {
                    bool x = va_arg(args, bool);
                    ((bool*)arr.elems)[index] = x;
                    return;    
                }
            }
        }
        default : {
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected ARRAY, got %s\n", 
                __FILE__,
                __func__, 
                type_to_str(type)
            );
            exit(EXIT_FAILURE);
        }
    }
}

int geti(Types type, ...) {
    va_list args;
    va_start(args, type);

    if (type != ARRAY) {
        fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected ARRAY, got %s\n", 
            __FILE__,
            __func__, 
            type_to_str(type)
        );
        exit(EXIT_FAILURE);
    }
    else {
        Array arr = va_arg(args, Array);
        type = va_arg(args, Types);
        int index = va_arg(args, int);
        int res = ((int*)arr.elems)[index];
        return res;
    }
}

double getf(Types type, ...) {
    va_list args;
    va_start(args, type);

    if (type != ARRAY) {
        fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected ARRAY, got %s\n", 
            __FILE__,
            __func__, 
            type_to_str(type)
        );
        exit(EXIT_FAILURE);
    }
    else {
        Array arr = va_arg(args, Array);
        type = va_arg(args, Types);
        int index = va_arg(args, int);
        double res = ((double*)arr.elems)[index];
        return res;
    }
}
#endif

#endif