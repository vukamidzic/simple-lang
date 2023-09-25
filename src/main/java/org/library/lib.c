#include "lib.h"

#include <stdio.h> 
#include <stdlib.h>
#include <stdbool.h>
#include <stdarg.h>

#include <math.h>
#include <limits.h>
#include <string.h>

char* type_to_str(Types type) {
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
        case PTR : {
            return "PTR";
        }
        case ARRAY : {
            return "ARRAY";
        }
        default : {
            return "UNDEFINED";
        }
    }
}

char* get_filename(char* path) {
    char* file = strrchr(path, '/');
    return file+1; // return string from the '/' 
}

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
                
            case PTR : 
                printf("%p ", va_arg(args, int*));
                break;

            case ARRAY : {
                Array arr = va_arg(args, Array);
                putchar('[');
                for (int i = 0; i < arr.size; ++i) {
                    (i == arr.size-1)? 
                        printf("%d", arr.elems[i]) :
                        printf("%d, ", arr.elems[i]);
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
    return;
}

void println(Types type, ...) {
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
                
            case PTR : 
                printf("%p ", va_arg(args, int*));
                break;

            case ARRAY : {
                Array arr = va_arg(args, Array);
                putchar('[');
                for (int i = 0; i < arr.size; ++i) {
                    (i == arr.size-1)? 
                        printf("%d", arr.elems[i]) :
                        printf("%d, ", arr.elems[i]);
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
    putc('\n', stdout);
    return;
}

void input(Types type, ...) {
    va_list args;
    va_start(args, type);

    while (type != FUNC_END) {
        if (type != PTR) {
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Non-pointer argument\n", 
                get_filename(__FILE__),
                __func__
            );
            exit(EXIT_FAILURE);
        }

        scanf("%d", va_arg(args, int*));
        type = va_arg(args, Types);
    }

    va_end(args);
    return;
}

int maxValue(Types type, ...) {
    va_list args;
    va_start(args, type);

    int maxVal = INT_MIN;

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER : {
                int i = va_arg(args, int);
                maxVal = (i > maxVal) ? i : maxVal;                
                break;
			}
            case DOUBLE : {
                int d = (int)round(va_arg(args, double));
                maxVal = (d > maxVal) ? d : maxVal;
                break;
			}
            case BOOL : {
                int b = va_arg(args, int);
                maxVal = (b > maxVal) ? b : maxVal;
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
    return maxVal;
}

int minValue(Types type, ...) {
    va_list args;
    va_start(args, type);

    int minVal = INT_MAX;

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER : {
                int i = va_arg(args, int);
                minVal = (i < minVal) ? i : minVal;
                break;
			}
            case DOUBLE : {
                int d = (int)round(va_arg(args, double));
                minVal = (d < minVal) ? d : minVal;
                break;
			}
            case BOOL : {
                int b = va_arg(args, int);
                minVal = (b < minVal) ? b : minVal;
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
    return minVal;
}

int _gcd(int a, int b) {
    while (b != 0) {
        int tmp = a % b;
        a = b;
        b = tmp;
    }

    return a;
}

int gcd(Types type, ...) {
    va_list args;
    va_start(args, type);

    int gcdVal;

    switch (type) {
        case INTEGER : 
            gcdVal = va_arg(args, int);
            break;

        case DOUBLE : 
            gcdVal = (int)round(va_arg(args, double));
            break;

        case BOOL : 
            gcdVal = va_arg(args, int);
            break;

        default : 
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Unknown type specifier %s\n",
                get_filename(__FILE__),
                __func__,
                type_to_str(type)
            );
            exit(EXIT_FAILURE);
    }

    type = va_arg(args, Types);

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER : {
                int i = va_arg(args, int);
                gcdVal = _gcd(gcdVal, i);
                break;
			}
            case DOUBLE : {
                int d = (int)round(va_arg(args, double));
                gcdVal = _gcd(gcdVal, d);
                break;
			}
            case BOOL : {
                int b = va_arg(args, int);
                gcdVal = _gcd(gcdVal, b);
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
    return gcdVal;
}

int lcm(Types type, ...) {
    va_list args;
    va_start(args, type);

    int lcmVal;

    switch (type) {
        case INTEGER : 
            lcmVal = va_arg(args, int);
            break;

        case DOUBLE : 
            lcmVal = (int)round(va_arg(args, double));
            break;

        case BOOL : 
            lcmVal = va_arg(args, int);
            break;

        default : 
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Unknown type specifier %s\n",
                get_filename(__FILE__),
                __func__,
                type_to_str(type)
            );
            exit(EXIT_FAILURE);
    }

    type = va_arg(args, Types);

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER : {
                int i = va_arg(args, int);
                lcmVal = (lcmVal*i)/_gcd(lcmVal, i);
                break;
			}
            case DOUBLE : {
                int d = (int)round(va_arg(args, double));
                lcmVal = (lcmVal*d)/_gcd(lcmVal, d);
                break;
			}
            case BOOL : {
                int b = va_arg(args, int);
                lcmVal = (lcmVal*b)/_gcd(lcmVal, b);
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
    return lcmVal;
}

int mod(Types type, ...) {
    va_list args;
    va_start(args, type);

    int t1, t2;

    switch (type) {
        case INTEGER :
            t1 = va_arg(args, int);
            break;
            
        case DOUBLE :
            t1 = (int)round(va_arg(args, double));
            break;
        
        case BOOL : 
            t1 = va_arg(args, int);
            break;    
            
        default : 
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Unknown type specifier %s\n",
                get_filename(__FILE__),
                __func__,
                type_to_str(type)
            );
            exit(EXIT_FAILURE);
    }

    type = va_arg(args, Types);

    switch (type) {
        case INTEGER :
            t2 = va_arg(args, int);
            break;
            
        case DOUBLE :
            t2 = (int)round(va_arg(args, double));
            break;
        
        case BOOL : 
            t2 = va_arg(args, int);
            break;    
            
        default : 
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Unknown type specifier %s\n",
                get_filename(__FILE__),
                __func__,
                type_to_str(type)
            );
            exit(EXIT_FAILURE);
    }

    type = va_arg(args, Types);

    if (type != FUNC_END) {
        fprintf(stderr, "[\033[35m%s\033[0m] %s(): Too many arguments for this function (expected 2)\n", 
            get_filename(__FILE__),
            __func__
        );
        exit(EXIT_FAILURE);
    }
    
    va_end(args);
    return t1 % t2;
}

double sini(Types type, ...) {
    va_list args;
    va_start(args, type);

    if (type != INTEGER) {
        fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected INT, got %s\n", 
            get_filename(__FILE__),
            __func__, 
            type_to_str(type)
        );
        exit(EXIT_FAILURE);
    }

    return sin(va_arg(args, int));
}

double cosi(Types type, ...) {
    va_list args;
    va_start(args, type);

    if (type != INTEGER) {
        fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected INT, got %s\n", 
            get_filename(__FILE__),
            __func__, 
            type_to_str(type)
        );
        exit(EXIT_FAILURE);
    }

    return cos(va_arg(args, int));
}

Array array(Types type, ...) {
    va_list args;
    va_start(args, type);

    int size = va_arg(args, int);
    if (size < 1) {
        fprintf(stderr, "[\033[35m%s\033[0m] %s(): Array size should be greater or equal to 1\n", 
            get_filename(__FILE__), 
            __func__
        );
        exit(EXIT_FAILURE);
    }

    type = va_arg(args, Types);
    int elem = va_arg(args, int);

    Array arr = {
        .elems = malloc(size*sizeof(int)),
        .size = size
    };
    
    for (int i = 0; i < size; ++i) {
        arr.elems[i] = elem;
    }

    return arr;
}

int get(Types type, ...) {
    va_list args;
    va_start(args, type);

    switch (type) {
        case ARRAY : {
            Array arr = va_arg(args, Array);
            type = va_arg(args, Types);

            if (type != INTEGER) {
                fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected INT, got %s\n", 
                    get_filename(__FILE__),
                    __func__, 
                    type_to_str(type)
                );
                exit(EXIT_FAILURE);    
            }

            int index = va_arg(args, int);
            if (index < 0 || index >= arr.size) {
                fprintf(stderr, "[\033[35m%s\033[0m] %s(): Index out of bounds\n", 
                    get_filename(__FILE__),
                    __func__
                );
                exit(EXIT_FAILURE);    
            }
            return arr.elems[index];
        }
        default : {
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected ARRAY, got %s\n", 
                get_filename(__FILE__),
                __func__, 
                type_to_str(type)
            );
            exit(EXIT_FAILURE);
        }
    }
}

int len(Types type, ...) {
    va_list args;
    va_start(args, type);

    switch (type) {
        case ARRAY : {
            Array arr = va_arg(args, Array);
            return arr.size;
        }
        default : {
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected ARRAY, got %s\n", 
                get_filename(__FILE__),
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
            int x = va_arg(args, int);
            arr.elems[index] = x;
            return;
        }
        default : {
            fprintf(stderr, "[\033[35m%s\033[0m] %s(): Expected ARRAY, got %s\n", 
                get_filename(__FILE__),
                __func__, 
                type_to_str(type)
            );
            exit(EXIT_FAILURE);
        }
    }
}