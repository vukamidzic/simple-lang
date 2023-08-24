#include <stdio.h> 
#include <stdlib.h>
#include <stdbool.h>
#include <stdarg.h>
#include <math.h>
#include "lib.h"

void print(enum Types type, ...) {
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
                printf("%d ", va_arg(args, int*));
                break;

            default : 
                fprintf(stderr, "Unknown type specifier!!!\n");
                break;
        }
        
        type = va_arg(args, enum Types);
    }
    
    va_end(args);
    return;
}

void println(enum Types type, ...) {
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
                printf("%d ", va_arg(args, int*));
                break;

            default : 
                fprintf(stderr, "Unknown type specifier!!!\n");
                break;
        }
        
        type = va_arg(args, enum Types);
    }
    
    va_end(args);
    putchar('\n');
    return;
}

void input(enum Types type, ...) {
    va_list args;
    va_start(args, type);

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER : 
                int i = va_arg(args, int);
                int* i_ptr = &i;
                scanf("%d", i_ptr);
                break;
        
            case DOUBLE :
                double d = va_arg(args, double);
                double* d_ptr = &d;
                scanf("%f", d_ptr);
                break;
            
            case BOOL : 
                int b = va_arg(args, int);
                int* b_ptr = &b;
                scanf("%d", b_ptr);
                break;    
                
            default : 
                fprintf(stderr, "Unknown type specifier!!!\n");
                exit(EXIT_FAILURE);
        }

        type = va_arg(args, enum Types);
    }

    return 0;
}

int maxValue(enum Types type, ...) {
    va_list args;
    va_start(args, type);

    int maxVal;

    switch (type) {
        case INTEGER : 
            maxVal = va_arg(args, int);
            break;

        case DOUBLE : 
            maxVal = (int)round(va_arg(args, double));
            break;

        case BOOL : 
            maxVal = va_arg(args, int);
            break;

        default : 
                fprintf(stderr, "Unknown type specifier!!!\n");
                return -1;
    }

    type = va_arg(args, enum Types);

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER :
                int i = va_arg(args, int);
                maxVal = (i > maxVal) ? i : maxVal;
                break;
                
            case DOUBLE :
                int d = (int)round(va_arg(args, double));
                maxVal = (d > maxVal) ? d : maxVal;
                break;
            
            case BOOL : 
                int b = va_arg(args, int);
                maxVal = (b > maxVal) ? b : maxVal;
                break;    
                
            default : 
                fprintf(stderr, "Unknown type specifier!!!\n");
                break;
        }
        
        type = va_arg(args, enum Types);
    }

    return maxVal;
}

int minValue(enum Types type, ...) {
    va_list args;
    va_start(args, type);

    int minVal;

    switch (type) {
        case INTEGER : 
            minVal = va_arg(args, int);
            break;

        case DOUBLE : 
            minVal = (int)round(va_arg(args, double));
            break;

        case BOOL : 
            minVal = va_arg(args, int);
            break;

        default : 
                fprintf(stderr, "Unknown type specifier!!!\n");
                return -1;
    }

    type = va_arg(args, enum Types);

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER :
                int i = va_arg(args, int);
                minVal = (i < minVal) ? i : minVal;
                break;
                
            case DOUBLE :
                int d = (int)round(va_arg(args, double));
                minVal = (d < minVal) ? d : minVal;
                break;
            
            case BOOL : 
                int b = va_arg(args, int);
                minVal = (b < minVal) ? b : minVal;
                break;    
                
            default : 
                fprintf(stderr, "Unknown type specifier!!!\n");
                break;
        }
        
        type = va_arg(args, enum Types);
    }

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

int gcd(enum Types type, ...) {
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
                fprintf(stderr, "Unknown type specifier!!!\n");
                return -1;
    }

    type = va_arg(args, enum Types);

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER :
                int i = va_arg(args, int);
                gcdVal = _gcd(gcdVal, i);
                break;
                
            case DOUBLE :
                int d = (int)round(va_arg(args, double));
                gcdVal = _gcd(gcdVal, d);
                break;
            
            case BOOL : 
                int b = va_arg(args, int);
                gcdVal = _gcd(gcdVal, b);
                break;    
                
            default : 
                fprintf(stderr, "Unknown type specifier!!!\n");
                break;
        }
        
        type = va_arg(args, enum Types);
    }

    return gcdVal;
}

int lcm(enum Types type, ...) {
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
            fprintf(stderr, "Unknown type specifier!!!\n");
            return -1;
    }

    type = va_arg(args, enum Types);

    while (type != FUNC_END) {
        switch (type) {
            case INTEGER :
                int i = va_arg(args, int);
                lcmVal = (lcmVal*i)/_gcd(lcmVal, i);
                break;
                
            case DOUBLE :
                int d = (int)round(va_arg(args, double));
                lcmVal = (lcmVal*d)/_gcd(lcmVal, d);
                break;
            
            case BOOL : 
                int b = va_arg(args, int);
                lcmVal = (lcmVal*b)/_gcd(lcmVal, b);
                break;    
                
            default : 
                fprintf(stderr, "Unknown type specifier!!!\n");
                break;
        }
        
        type = va_arg(args, enum Types);
    }

    return lcmVal;
}

int mod(enum Types type, ...) {
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
            fprintf(stderr, "Unknown type specifier!!!\n");
            break;
    }

    type = va_arg(args, enum Types);

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
            fprintf(stderr, "Unknown type specifier!!!\n");
            break;
    }

    type = va_arg(args, enum Types);

    if (type != FUNC_END) {
        fprintf(stderr, "(mod) Too many arguments for this function (expected 2)");
        exit(EXIT_FAILURE);
    }
    return t1 % t2;
}