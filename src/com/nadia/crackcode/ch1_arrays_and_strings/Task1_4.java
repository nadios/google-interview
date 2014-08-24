package com.nadia.crackcode.ch1_arrays_and_strings;

/**
 * Write a method to decide if two strings are anagrams or not
 */
public class Task1_4 {

    public static void main(String[] args) {
        System.out.println(are_anagrams("cba","abc"));
        System.out.println(are_anagrams("cbad","abcf"));
        System.out.println(are_anagrams("cbda","abdc"));
        System.out.println(are_anagrams("cbaa","aabc"));
        System.out.println(are_anagrams("cbada","abcfd"));

    }

    private static boolean are_anagrams(String s1, String s2) {
        int[] chars = new int[256];

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (char ch1 : chars1) {
            chars[ch1] += 1;
        }
        for (char ch2: chars2) {
            if (chars[ch2] == 0) {
                return false;
            }
            chars[ch2] -=1;
        }
        for (int x: chars) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

}
