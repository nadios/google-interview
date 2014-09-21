package com.nadia.crackcode.ch9_sort_and_search;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a method to sort an array of strings so that all the anagrams are next to each other
 */
public class Task9_2 {

    public static void main(String[] args) {
        String[] str_array = new String[]{"test", "abcz", "zcba", "baab"};
        Arrays.sort(str_array, new AnagramComparator());
        for (String s : str_array) System.out.print(s + "   ");
    }

    private static class AnagramComparator implements Comparator<String> {

        public String sortChars(String orig) {
            char[] chars = orig.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }


        @Override
        public int compare(String o1, String o2) {
            return sortChars(o1).compareTo(sortChars(o2));
        }
    }
}
