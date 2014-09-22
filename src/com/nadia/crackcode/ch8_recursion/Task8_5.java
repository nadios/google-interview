package com.nadia.crackcode.ch8_recursion;

/**
 * Implement an algorithm to print all valid (e g , properly opened and closed) combinations of n-pairs of parentheses
 * EXAMPLE:
 * input: 3 (e g , 3 pairs of parentheses)
 * output: ()()(), ()(()), (())(), ((())), (()())
 */
public class Task8_5 {

    public static void main(String[] args) {
        print_parens(0, 3, 3, new char[3 * 2]);
    }

    public static void print_parens(int count, int l, int r, char[] str) {
        if (l < 0 || r < l) return;
        if (l == 0 && r == 0) {
            System.out.println(new String(str) + "; ");
            return;
        }
        if (l > 0) {
            str[count] = '(';
            print_parens(count + 1, l - 1, r, str);
        }
        if (r > l) {
            str[count] = ')';
            print_parens(count + 1, l, r - 1, str);
        }
    }
}
