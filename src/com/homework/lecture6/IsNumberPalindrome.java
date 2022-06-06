package com.homework.lecture6;

import java.util.Scanner;

public class IsNumberPalindrome {

    public static boolean isPalindrome(int number){
        int originalNumber = number;
        boolean isPalindrome = false;
        int remainder;
        int reversedNum = 0;
        while (number != 0) {
            remainder = number % 10;
            reversedNum = reversedNum * 10 + remainder;
            number /= 10;
        }

        if (originalNumber == reversedNum) {
            isPalindrome = true;
        }
        else {
            isPalindrome = false;
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int number = in.nextInt();
        System.out.println(isPalindrome(number));
    }
}
