package com.homework.lecture6;

import java.util.Scanner;

public class IsEven {

    public static boolean isEven(int number) {
        boolean isEven = false;
        if (number % 2 == 0){
            isEven = true;
        } else {
            isEven = false;
        }
        return isEven;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int number = in.nextInt();
        System.out.println(isEven(number));
    }
}
