package com.nadia.crackcode.ch8_recursion;

/**
 * Write a method to generate the nth Fibonacci number
 */
public class Task8_1 {

    public static void main (String[] args) {
        System.out.println(fibonacci(9));
    }
    //1 1 2 3 5 8 13 21 34
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        if (n > 2) {
            return fibonacci(n-1) + fibonacci(n-2);
        }
        return 0;
    }
}
