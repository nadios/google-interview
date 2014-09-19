package com.nadia.crackcode.victor;

import java.util.LinkedList;

/**
 * check valid 2type parentheses strings
 */
public class Task1_parentheses {

    public static void main(String[] args) {
//        System.out.println("is valid (){}{(){}} : " + isValid("(){}{(){}}"));
//        System.out.println("is valid (){}{({)}{}} : " + isValid("(){}{({)}{}}"));
//        System.out.println("is valid ){}{({)}{}}( : " + isValid("){}{({)}{}}("));
        System.out.println("is valid (){}{(){}} : " + check_parens_str("(){}{(){}}"));
        System.out.println("is valid (){}{({)}{}} : " + check_parens_str("(){}{({)}{}}"));
        System.out.println("is valid ){}{({)}{}}( : " + check_parens_str("){}{({)}{}}("));
    }

    public static Boolean isValid(String str) {
        LinkedList<Character> stack = new LinkedList<Character>();
        char[] chars = str.toCharArray();
        int i1 = 0, i2 = 0, j1 = 0, j2 = 0;
        int o = 0;
        for (char c : chars) {
            if (i2 > i1 || j2 > j1) {
                return false;
            }
            if (c == '(') {
                i1++;
                stack.add(c);
            } else if (c == '{') {
                j1++;
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                char last = stack.removeLast();
                if (c == ')') {
                    if (last == '(') {
                        i2++;
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (last == '{') {
                        j2++;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (i1 == i2 && j1 == j2) return true;
        return false;
    }

    public static boolean check_parens_str(String s) {
        if (s == null) return false;
        LinkedList stack = new LinkedList();
        int i1 = 0, i2 = 0, j1 = 0, j2 = 0;
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c == '(' || c == '{') {
                stack.add(c);
                if (c == '(') i1++;
                else if (c == '{') j1++;
            } else if (c == ')' || c == '}') {
                if (stack.isEmpty()) return false;
                char last = (Character) stack.peekLast();
                if (c == ')') {
                    if (last != '(') return false;
                    i2++;
                } else {
                    if (last != '{') return false;
                    j2++;
                }
            }
        }
        return (i1 == i2 && j1 == j2);

    }
}
