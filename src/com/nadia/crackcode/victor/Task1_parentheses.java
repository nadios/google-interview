package com.nadia.crackcode.victor;

import java.util.LinkedList;

/**
 * check valid 2type parentheses strings
 */
public class Task1_parentheses {

    public static void main(String[] args) {
        System.out.println("is valid (){}{(){}} : " + check_parens_str("(){}{(){}}"));
        System.out.println("is valid (){}{({)}{}} : " + check_parens_str("(){}{({)}{}}"));
        System.out.println("is valid ){}{({)}{}}( : " + check_parens_str("){}{({)}{}}("));
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
