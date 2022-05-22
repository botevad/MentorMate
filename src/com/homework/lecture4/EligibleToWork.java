package com.homework.lecture4;

import java.util.Scanner;

public class EligibleToWork {
    public static void main(String[] args) {
        int age;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your age:");
        age = scanner.nextInt();
        if (age >= 16) {
            System.out.println("You are eligible to work");
        } else if (age >= 1 && age < 16) {
            System.out.println("You are NOT eligible to work");
        } else {
            System.out.println("Please enter a valid age value!");
        }
    }
}
