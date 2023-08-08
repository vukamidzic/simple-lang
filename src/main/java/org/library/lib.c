#include <stdio.h> 
#include <stdlib.h>
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
                printf((va_arg(args, int))? "true " : "false ");
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
                printf((va_arg(args, int))? "true " : "false ");
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