package com.nadia.crackcode.ch1_arrays_and_strings;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer NOTE: One or two additional variables are fine
 * An extra copy of the array is not
 * FOLLOW UP
 * Write the test cases for this method
 */
public class Task1_3 {
    public static void main(String[] args) {
        System.out.println(remove_duplicates("abcdefs"));
        System.out.println(remove_duplicates("abcdseafs"));
    }

    public static String remove_duplicates(String s) {
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[j] == chars[i]) {
                    chars[i] = '_';
                }
            }
        }
        return new String(chars);
    }


}
