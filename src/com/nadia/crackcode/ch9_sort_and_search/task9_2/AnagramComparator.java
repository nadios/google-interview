package com.nadia.crackcode.ch9_sort_and_search.task9_2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The basic idea is to implement a normal sorting algorithm where you override the
 * compareTo method to compare the “signature” of each string.
 * In this case, the signature is the alphabetically sorted string.
 */
public class AnagramComparator implements Comparator<String> {

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
