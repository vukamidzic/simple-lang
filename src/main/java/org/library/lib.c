#include <stdio.h>
#include <stdbool.h>
#include <stdarg.h>
#include "lib.h"

void printInt(int n, ...) {
    va_list args;
    va_start(args, n);

    for (int i = 0; i < n; ++i) {
        printf("%d ", va_arg(args, int));
    }
    putchar('\n');
}

void printFloat(int n, ...) {
    va_list args;
    va_start(args, n);

    for (int i = 0; i < n; ++i) {
        printf("%.2lf ", va_arg(args, double));
    }
    putchar('\n');
}

void printBool(int n, ...) {
    va_list args;
    va_start(args, n);

    for (int i = 0; i < n; ++i) {
        printf("%s ", (va_arg(args, int)) ? "true " : "false ");
    }
    putchar('\n');
}
