package com.nadia.crackcode.vira;

import java.util.ArrayList;
import java.util.List;

/**
 * return the kth smallest item form a collection.
 */
public class Task5_kth_smallest {

    public static void main(String[] args) {
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
        System.out.println("PROCESSED: " + find_kth(array, 2));
    }

    public static Integer find_kth(List list, int k) {
        return quicksort(list, k, 0, list.size() - 1);
    }

    private static Integer quicksort(List list, int k, int start, int end) {
        if (start < 0 || end >= list.size()) return null;
        if (start > end) return null;
        Integer value = (Integer) list.get(end);
        int partition = partition(list, value, start, end - 1);
        if (k > partition) return quicksort(list, end - k, partition + 1, end);
        if (k < partition) return quicksort(list, k, start, partition - 1);
        return (Integer) list.get(partition);
    }

    private static Integer partition(List list, int value, int leftInd, int rightInd) {
        int l = leftInd;
        int r = rightInd;

        while (l < r) {
            if (value > (Integer) list.get(l)) {
                l++;
                continue;
            }
            if (value <= (Integer) list.get(r)) {
                r--;
                continue;
            }
            swap(list, l, r);
            l++;
        }
        return l;
    }

    private static void swap(List list, int a, int b) {
        if (a == b) return;
        Integer aValue = (Integer) list.get(a);
        list.set(a, list.get(b));
        list.set(b, aValue);
    }

    private static void printArray(String name, List arr) {
        System.out.println(name);
        for (Object i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println("");
    }
}
