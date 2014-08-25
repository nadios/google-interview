package com.nadia.crackcode.ch9_sort_and_search;

/**
 * Given a matrix in which each row and each column is sorted, write a method to find an element in it
 */
public class Task9_6 {

    public static void main(String[] args) {
        Integer[][]matrix = new Integer[][] {{2,4,6,7},{10,10,12,15},{16,17,19,20}} ;
        findElement(matrix,10);
        findElement(matrix,1);
        findElement(matrix,18);
        findElement(matrix,20);
        findElement(matrix,7);
    }

    public static void findElement(Integer[][] matrix, int x) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (x == matrix[i][j]) {
                System.out.println("matrix[" + i + "][" + j + "]=" + x);
                return;
            } else if (x > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(x + " not found in the matrix");

    }
}
