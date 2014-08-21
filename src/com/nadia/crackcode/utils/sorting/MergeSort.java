package com.nadia.crackcode.utils.sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Merge Sort algo implementation
 */
public class MergeSort {

    public static void main(String args[]) {
        int[] arr = {9, 23, 5, 1, 6, 0, 2, 5, 7, 8, 3, 4};
        printArray("INITIAL:", arr);
        printArray("PROCESSED:", sort(arr));
    }

    public static int[] sort(int[] array) {
        return mergesort(array);
    }

    private static int[] mergesort(int[] list) {
        if (list.length <= 1) {
            return list;
        }
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        mergesort(first);
        mergesort(second);
        return merge(first, second, list);
    }

    private static int[] merge(int[] left, int[] right, int[] result) {
        int l = 0, r = 0, k = 0;
        while (l < left.length || r < right.length) {
            if (l >= left.length) {
                result[k] = right[r];
                r++;
            } else if (r >= right.length) {
                result[k] = left[l];
                l++;
            } else if ((Integer) left[l] < (Integer) right[r]) {
                result[k] = left[l];
                l++;
            } else {
                result[k] = right[r];
                r++;
            }
            k++;
        }
        return result;
    }

    private static void printArray(String name, int[] arr) {
        System.out.println(name);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("");
    }

}
