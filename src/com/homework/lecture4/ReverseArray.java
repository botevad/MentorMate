package com.homework.lecture4;

import com.sun.security.jgss.GSSUtil;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Original Array:");
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println("Printing the array in reversed order:");
        for (int i = arr.length-1; i >=0 ; i--) {
            System.out.println(arr[i] + " ");
        }
    }
}
