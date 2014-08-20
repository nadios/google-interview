package com.nadia.crackcode.ch1;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees Can you do this in place?
 */
public class Task1_6 {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        rotate_matrix(matrix,4);
//                {0 * 0, 1 * 0, 2 * 0, 3 * 0},
//                {0 * 1, 1 * 1, 2 * 1, 3 * 1},
//                {0 * 2, 1 * 2, 2 * 2, 3 * 2},
//                {0 * 3, 1 * 3, 2 * 3, 3 * 3}


    }

    private static void rotate_matrix(int[][] matrix, int n) {
        int[][] rows = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rows[i][j] = matrix[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rows[i][n-j-1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("    ");
            }

            System.out.println("");
        }

    }

}
