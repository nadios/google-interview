package com.nadia.crackcode.ch9_sort_and_search;

import com.nadia.crackcode.ch9_sort_and_search.task9_2.AnagramComparator;

import java.util.Arrays;

/**
 * Write a method to sort an array of strings so that all the anagrams are next to each other
 */
public class Task9_2 {

    public static void main(String[] args) {
        String[]str_array = new String[]{"test", "abcz", "zcba", "baab"};
        Arrays.sort(str_array, new AnagramComparator());
        for (String s: str_array) System.out.print(s + "   ");
    }
}
