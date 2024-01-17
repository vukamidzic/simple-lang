#include "config.h"
#include "common.h"

#include <stdio.h>
#include <stdio.h> 
#include <stdlib.h>
#include <stdbool.h>
#include <stdarg.h>
#include <stdint.h>
#include <string.h>

#ifndef S_BASIC_H
#define S_BASIC_H

#ifdef BASIC
void print(Types type, ...) {
    va_list args;
    va_start(args, type);
    
    while (type != FUNC_END) {
        switch (type) {
            case INTEGER : 
                printf("%d ", va_arg(args, int));
                break;
                
            case DOUBLE :
                printf("%.2f ", va_arg(args, double));
                break;
            
            case BOOL : 
                printf((va_arg(args, bool))? "true " : "false ");
                break;    
                
            case CHAR : 
                printf("%c ", va_arg(args, char));
                break;

            case ARRAY : {
                Array arr = va_arg(args, Array);
                uint32_t size = arr.data & (((1 << 16) - 1));
                putchar('[');
                for (int i = 0; i < size; ++i) {
                    uint32_t ty = arr.data >> 16;
                    if (i == size-1) {
                        switch (ty) {
                            case INTEGER : { 
                                printf("%d", ((int*)arr.elems)[i]);
                                break;
                            }
                            case DOUBLE : { 
                                printf("%.2f", ((double*)arr.elems)[i]);
                                break;
                            }
                            case BOOL : { 
                                printf("%d", ((bool*)arr.elems)[i]);
                                break;
                            }
                            case CHAR : { 
                                printf("%c", ((char*)arr.elems)[i]);
                                break;
                            }
                        }
                    } 
                    else {
                        switch (ty) {
                            case INTEGER : { 
                                printf("%d, ", ((int*)arr.elems)[i]);
                                break;
                            }
                            case DOUBLE : { 
                                printf("%.2f, ", ((double*)arr.elems)[i]);
                                break;
                            }
                            case BOOL : { 
                                printf("%d, ", ((bool*)arr.elems)[i]);
                                break;
                            }
                            case CHAR : { 
                                printf("%c, ", ((char*)arr.elems)[i]);
                                break;
                            }
                        }
                    }
                        
                }
                putchar(']');
                break;
            }

            default : 
                fprintf(stderr, "[\033[35m%s\033[0m] %s(): Unknown type specifier %s\n",
                    get_filename(__FILE__),
                    __func__,
                    type_to_str(type)
                );
                exit(EXIT_FAILURE);
        }
        
        type = va_arg(args, Types);
    }
    
    va_end(args);
    putchar('\n');
    return;
}

int input(Types type, ...) {
    va_list args;
    va_start(args, type);

    while (type != FUNC_END) {
        if (type == INT_PTR) {
            int* p = *(va_arg(args, int**));
            scanf("%d", p);
        }
        else if (type == FLOAT_PTR) {
            double* p = *(va_arg(args, double**));
            scanf("%lf", p);
        }
        else {
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Non-pointer argument\n", 
                get_filename(__FILE__),
                __func__
            );
            return -1;
        }
        type = va_arg(args, Types);
    }

    va_end(args);
    return 0;
}

#endif

#endif