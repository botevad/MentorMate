package com.homework.lecture5;

public class ArrayBiggestElement_ArrayElementSum {
    public static void main(String[] args) {
        int[] numbers =  {1,2,3,4,5};

        int max = numbers[0];
        int arraySum = 0;
        for (int i = 0; i < numbers.length ; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
            arraySum += numbers[i];
        }
        System.out.println("The biggest array element is: " + max);
        System.out.println("The sum of the array elements is: " + arraySum);
    }
}
