package com.homework.lecture5;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int diagonalSum1 = 0;
        //int diagonalSum2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i + j;
                System.out.printf("%d", matrix[i][j]);
                if (i==j) {
                    diagonalSum1 += matrix[i][j];
                }
            }
            System.out.println();
        }
        //diagonalSum1 = matrix[0][0] + matrix[1][1] + matrix[2][2] + matrix[3][3];
        //diagonalSum2 = matrix[0][3] + matrix[1][2] + matrix[2][1] + matrix[3][0];
        System.out.println("The sum of the diagonal of the matrix is: " + diagonalSum1);
    }

}
