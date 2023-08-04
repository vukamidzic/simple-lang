#include <stdio.h>
#include <stdbool.h>
#include "lib.h"

void printInt(int n) {
    printf("%d\n", n);
};

void printFloat(float n) {
    printf("%.2f\n", n);    
};

void printBool(bool n) {
    printf((n)? "true\n" : "false\n");
};

int num(int n) {
    return n;
}
