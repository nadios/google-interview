package com.nadia.crackcode.ch9_sort_and_search;

/**
 * Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
 * Example: find "ball" in ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] will return 4
 * Example: find "ballcar" in ["at", "", "", "", "", "ball", "car", "", "", "dad", "", ""] will return -1
 */
public class Task9_5 {

    public static void main(String[] args) {
        String[] str_arr = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println("Str at: " + findStr(str_arr, "at"));
        System.out.println("Str st: " + findStr(str_arr, "st"));
        System.out.println("Str car: " + findStr(str_arr, "car"));
        System.out.println("Str dad: " + findStr(str_arr, "dad"));
        System.out.println("Str ball: " + findStr(str_arr, "ball"));
    }

    public static Integer findStr(String[] str_arr, String x) {
        int i = 0, j = str_arr.length - 1;
        while (j >= i) {
            int m = (j + i) / 2;
            int init_m=m;
//            System.out.println("i="+i+",j="+j+",m="+m);
//            System.out.println("1find m");
            m = findNext(str_arr, m, j);
            if (m > -1) {
                if (x.compareTo(str_arr[m]) == 0) {
                    return m;
                } else if (x.compareTo(str_arr[m]) < 0) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            } else {
//                System.out.println("2find m");
                m = findNext(str_arr, 0, init_m-1);
                if (m > -1) j = init_m-1;
                else return null;
            }
        }
        return null;
    }

    public static Integer findNext(String[] str_arr, int i, int j) {
//        System.out.println("searching next i="+i+",j="+j);
        for (int x = i; x <= j; x++) {
            if (str_arr[x] != "") {
//                System.out.println("x="+x);
                return x;
            }
        }
        return -1;
    }
}
