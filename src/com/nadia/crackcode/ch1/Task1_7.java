package com.nadia.crackcode.ch1;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column is set to 0
 */
public class Task1_7 {

    public static void main(String args[]) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {0, 13, 14, 15}
        };
        zeroize_matrix(matrix);

    }

    private static void zeroize_matrix(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] colums = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    colums[j] = 1;
                }
            }
        }

        for (int j=0;j<matrix[0].length;j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (rows[i]==1 || colums[j]==1) {
                    matrix[i][j]=0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("    ");
            }

            System.out.println("");
        }

    }


}
