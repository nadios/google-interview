package com.nadia.crackcode.ch8_recursion;

/**
 * Implement an algorithm to print all valid (e g , properly opened and closed) combinations of n-pairs of parentheses
 * EXAMPLE:
 * input: 3 (e g , 3 pairs of parentheses)
 * output: ()()(), ()(()), (())(), ((())), (()())
 */
public class Task8_5 {

    public static void main(String[] args) {
//        print_braces(3);
//        printParentheses(0, 3, 3, new char[3 * 2]);
        print_parens(0, 3, 3, new char[3 * 2]);
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
            }
            if (r > l) {
                str[count] = ')';
                print_braces(l, r - 1, str, count + 1);
            }
        }
    }


    public static void printParentheses(int count, int l, int r, char[] buffer) {
        if (l > r || l < 0) return;
        if (r == 0 && l == 0) {
            System.out.println(new String(buffer));
        } else {
            if (l > 0) {
                buffer[count] = '(';
                printParentheses(count + 1, l - 1, r, buffer);
            }
            if (r > l) {
                buffer[count] = ')';
                printParentheses(count + 1, l, r - 1, buffer);
            }
        }
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
