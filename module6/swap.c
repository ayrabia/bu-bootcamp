#include <stdio.h>

void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b){
    int temp = a;
    a = b;
    b = temp;
}

int main(void){
    int x = 10, y = 20;

    printf("Working Swap (Using Pointers): ");
    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap: x = %d, y = %d\n\n", x, y);

    int m = 5, n = 99;
    printf("Broken Swap (Value Copies): ");
    printf("Before Broken Swap: m = %d, n = %d\n", m, n);
    broken_swap(m,n);
    printf("After broken swap: m = %d, n = %d",m,n);

}