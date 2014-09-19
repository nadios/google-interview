package com.nadia.crackcode.vira;

/**
 * найти максимальную сумму в массиве integer-ов (в массиве есть и положительные и отрицательные числа)
 */
public class Task3_max_sum {

    public static void main(String[] args) {

        int[] array = new int[]{7, 2, 5, 7, 6, -30, 10, -13, -2, 20, 1, 5};
        max_sum(array);

    }

    public static void max_sum(int[] a) {
        int sum = 0, sumL = 0, sumR = -0,
                curSum = 0, pre_pos = -1;
        for (int i = 0; i < a.length; i++) {
            curSum += a[i];
            if (curSum > sum) {
                sum = curSum;
                sumL = pre_pos + 1;
                sumR = i;
            }
            if (curSum < 0) {
                curSum = 0;
                pre_pos = i;
            }
        }
        System.out.println("(" + sumL + " : " + sumR + ")");
        System.out.println("sum = " + sum);
    }
}
