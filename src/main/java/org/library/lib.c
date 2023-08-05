#include <stdio.h> 
#include <stdarg.h>
#include "lib.h"

void printInts(int n, ...) {
    va_list args;
    va_start(args, n);

    for (int i = 0; i < n; ++i) {
        printf("%d ", va_arg(args, int));
    }
    putchar('\n');

    va_end(args);
}

void printFloats(int n, ...) {
    va_list args;
    va_start(args, n);

    for (int i = 0; i < n; ++i) {
        printf("%.2f ", va_arg(args, double));
    }
    putchar('\n');

    va_end(args);
}

void printBool(int n, ...) {
    va_list args;
    va_start(args, n);

    for (int i = 0; i < n; ++i) {
        printf("%d ", va_arg(args, int));
    }
    putchar('\n');

    va_end(args);
}
