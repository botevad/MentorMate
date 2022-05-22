package com.homework.lecture4;

import java.util.Arrays;

public class LargestArrayNumber {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Arrays.sort(arr);
        System.out.println("sorted Array: "+Arrays.toString(arr));
        int largestElement = arr[arr.length -1];
        System.out.println("largest element is: " + largestElement);


    }
}
