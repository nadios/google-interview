package com.nadia.crackcode.ch1;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of
 * another Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
 * only one call to isSubstring (i e , “waterbottle” is a rotation of “erbottlewat”)
 */
public class Task1_8 {

    public static void main(String args[]) {
        System.out.println(is_rotation("waterbottle", "erbottlewat"));
        System.out.println(is_rotation("waterbotttle", "terbottlewat"));
    }

    public static boolean is_rotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        String word = s1 + s1;

        if (isSubstring(word, s2)) {
            return true;
        }

        return false;
    }

    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
