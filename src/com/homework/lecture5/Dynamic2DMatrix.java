package com.homework.lecture5;

import java.util.Scanner;

public class Dynamic2DMatrix {
    public static void main(String[] args) {

                System.out.print("Enter the number of rows: ");
                Scanner sc = new Scanner(System.in);
                int row = sc.nextInt();

                System.out.print("Enter the number of columns: ");
                int column = sc.nextInt();

                //declare the 2d array
                int[][] matrix = new int[row][column];

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        System.out.print(String.format("Enter element[%d][%d] : ", i, j));
                        matrix[i][j] = sc.nextInt();
                    }
                }

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        System.out.print(matrix[i][j] + "\t");
                    }
                    System.out.println();
                }

                // close the scanner object
                sc.close();


    }
}
