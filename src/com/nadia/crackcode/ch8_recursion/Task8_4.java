package com.nadia.crackcode.ch8_recursion;

import java.util.ArrayList;

/**
 * Write a method to compute all permutations of a string
 */
public class Task8_4 {

    public static void main(String[] args) {
        ArrayList<String> perms = permutations("abcd");
        for (String perm: perms) {
            System.out.println(perm);
        }
    }

    public static ArrayList<String> permutations(String str) {
        int len = str.length();
        ArrayList<String> permutations = new ArrayList<String>();
        if (len <=1) {
            permutations.add(str);
        } else if (len > 2) {
            String letter = str.substring(len - 1);
            String otherStr = str.substring(0, len - 1);
            ArrayList<String> prPerms = permutations(otherStr);
            for (String perm : prPerms) {
                for (int i = 0; i <= perm.length(); i++) {
                    permutations.add(perm.substring(0,i) + letter + perm.substring(i));
                }
            }
        } else {
            permutations.add(str);
            permutations.add(new StringBuilder(str).reverse().toString());
        }
        return permutations;
    }
}
