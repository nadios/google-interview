package com.nadia.crackcode.ch8;

/**
 * Implement an algorithm to print all valid (e g , properly opened and closed) combinations of n-pairs of parentheses
 * EXAMPLE:
 * input: 3 (e g , 3 pairs of parentheses)
 * output: ()()(), ()(()), (())(), ((())), (()())
 */
public class Task8_5 {

    public static void main(String[] args) {
        print_braces(3);
    }

    public static void print_braces(int count) {
        print_braces(count, count, new char[count * 2], 0);
    }


    private static void print_braces(int l, int r, char[] str, int count) {
        if (l > r || l < 0) {
            return;
        } else if (l == 0 && r == 0) {
            System.out.println(new String(str));
        } else {
            if (l > 0) {
                str[count] = '(';
                print_braces(l - 1, r, str, count + 1);
            } if (r > l) {
                str[count] = ')';
                print_braces(l, r - 1, str, count + 1);
            }
        }
    }
}
