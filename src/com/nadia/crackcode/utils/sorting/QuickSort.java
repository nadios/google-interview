package com.nadia.crackcode.utils.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Quick Sort impl
 */
public class QuickSort {
    public static void main(String args[]) {
        List<Integer> array = new ArrayList<Integer>();
        array.add(9);
        array.add(23);
        array.add(5);
        array.add(1);
        array.add(6);
        array.add(0);
        array.add(2);
        array.add(5);
        array.add(7);
        array.add(9);
        array.add(8);
        array.add(3);
        array.add(4);
        printArray("INITIAL:", array);
        sort(array);
        printArray("PROCESSED:", array);
    }

    private static void sort(List array) {
        quicksort(array, 0, array.size() - 1);
    }

    private static void quicksort(List list, int leftIndex, int rightIndex) {
        if (leftIndex < 0 || rightIndex >= list.size()) return;
        if (leftIndex >= rightIndex) return;
        Integer value = (Integer) list.get(rightIndex);
        int partition = partition(list, value, leftIndex, rightIndex - 1);
        if ((Integer) list.get(partition) < value) partition++;
        swap(list, partition, rightIndex);
        quicksort(list, leftIndex, partition - 1);
        quicksort(list, partition + 1, rightIndex);
    }

    private static int partition(List list, Integer value, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        while (left < right) {
            if ((Integer) list.get(left) < value) {
                left++;
                continue;
            }
            if ((Integer) list.get(right) >= value) {
                right--;
                continue;
            }
            swap(list, left, right);
            left++;
        }

        return left;
    }

    private static void swap(List list, int left, int right) {
        if (left == right) {
            return;
        }
        Object temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }

    private static void printArray(String name, List arr) {
        System.out.println(name);
        for (Object i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("");
    }
}
