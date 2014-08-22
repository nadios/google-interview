package com.nadia.crackcode.utils.search;

/**
 * Binary search algo
 */
public class BinarySearch {

    public static void main(String args[]) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 13, 14, 15, 16};
        System.out.println("search 5 : " + search(5, array));
        System.out.println("search 0 : " + search(0, array));
        System.out.println("search 17 : " + search(17, array));
        System.out.println("search 12 : " + search(12, array));
        System.out.println("search 11 : " + search(11, array));
        System.out.println("search 13 : " + search(13, array));
    }

    public static Integer search(int value, int[] list) {
        int start = 0;
        int fin = list.length - 1;
        while (start <= fin) {
            int mid = (start + fin) / 2;
            if (value == list[mid]) {
                return mid;
            } else if (value > list[mid]) {
                start = mid + 1;
            } else {
                fin = mid - 1;
            }
        }
        return null;
    }

}
