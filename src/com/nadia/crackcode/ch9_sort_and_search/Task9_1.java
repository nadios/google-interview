package com.nadia.crackcode.ch9_sort_and_search;

/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 */
public class Task9_1 {

    public static void main(String args[]) {
        Integer[] arrA = new Integer[]{1, 3, 5, 7, 7, 8, 9, 10, 13, 15
                , null, null, null, null, null, null, null, null, null, null};
        Integer[] arrB = new Integer[]{2, 2, 4, 6, 8, 10, 19, 20, 21, 25};
        int sizeA = 10;
        int sizeB = 10;
        System.out.println("MERGE : ");
        for (int i: merge(arrA, arrB, sizeA, sizeB)) {
            System.out.print(i + "  ");
        }
    }

    public static Integer[] merge(Integer[] arrA, Integer[] arrB, int sizeA, int sizeB) {
        int i = sizeA - 1, j = sizeB - 1, k = sizeA + sizeB - 1;
        while (i >= 0 || j >= 0) {
//            System.out.println("i=" + i + ",j=" + j + ",k=" + k);
            if (j < 0) {
                arrA[k] = arrA[i];
                i--;
            } else if (i < 0) {
                arrA[k] = arrB[j];
                j--;
            } else if (arrA[i] > arrB[j]) {
                arrA[k] = arrA[i];
                i--;
            } else {
                arrA[k] = arrB[j];
                j--;
            }
            k--;
        }
        return arrA;
    }
}
