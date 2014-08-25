package com.nadia.crackcode.ch9_sort_and_search;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times,
 * give an O(log n) algorithm that finds an element in the array.
 * You may assume that the array was originally sorted in increasing order.
 * EXAMPLE:
 * Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 * Output: 8 (the index of 5 in the array)
 */
public class Task9_3 {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println("search 4 : " + search(4, arr));
        System.out.println("search 16 : " + search(16, arr));
        System.out.println("search 12 : " + search(12, arr));
        System.out.println("search 15 : " + search(15, arr));
    }

    public static int search(int x, Integer[] array) {
        int l = 0, u = array.length - 1;
        while (l <= u) {
            int m = (l + u) / 2;
            if (array[m] == x) {
                return m;
            } else if (x > array[m]) {
                if (x < array[u]) {
                    l = m + 1;
                } else if (x > array[u]) {
                    u = m - 1;
                } else {
                    return u;
                }
            } else if (x < array[m]) {
                if (x > array[l]) {
                    u = m - 1;
                } else if (x < array[l]) {
                    l = m + 1;
                } else {
                    return l;
                }
            }
        }
        return -1;
    }
}
