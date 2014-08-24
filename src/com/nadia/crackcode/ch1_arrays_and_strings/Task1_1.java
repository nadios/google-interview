package com.nadia.crackcode.ch1_arrays_and_strings;

/**
 * Implement an algorithm to determine if a string has all unique characters What if
 * you can not use additional data structures?
 */
public class Task1_1 {
    public static void main(String[] args) {
        System.out.println(all_unique1("abcdef"));
        System.out.println(all_unique1("abcdefda"));
        System.out.println(all_unique2("abcdef"));
        System.out.println(all_unique2("abcdefda"));
    }

    //with data structure
    public static boolean all_unique1(String s) {
        boolean[] buffer = new boolean[256];
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (buffer[ch]) {
                return false;
            }
            buffer[ch] = true;
        }

        return true;
    }

    //without data structure
    public static boolean all_unique2(String s) {
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[j] == chars[i]) {
                    return false;
                }
            }
        }
        return true;
    }


}
