package com.homework.lecture4;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        double angleA, angleB, angleC, sumAngles;
        double sideA, sideB, sideC;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add angleA");
        angleA = scanner.nextDouble();

        System.out.println("Add angleB:");
        angleB = scanner.nextDouble();

        System.out.println("Add angleC:");
        angleC = scanner.nextDouble();

        sumAngles = angleA + angleB + angleC;

        if (angleA > 0 && angleB > 0 && angleC > 0) {
            if (sumAngles == 180) {
                System.out.println("The triangle is possible");

                if (angleA == 90 || angleB == 90 || angleC == 90) {
                    System.out.println("The triangle is right-angled");
                    if (angleA == 90 || angleB == 45 || angleC == 45) {
                        System.out.println("The triangle is isosceles right-angled");
                    }
                }

                System.out.println("Add sideA:");
                sideA = scanner.nextDouble();

                System.out.println("Add sideB:");
                sideB = scanner.nextDouble();

                System.out.println("Add sideC:");
                sideC = scanner.nextDouble();

                if (angleA < 90 && angleB < 90 && angleC < 90) {
                    if (sideA == sideB || sideA == sideC || sideB == sideC){
                        System.out.println("The triangle is acute isosceles");
                    } else if (sideA == sideB && sideB == sideC){
                        System.out.println("The triangle is acute equilateral");
                    } else {
                        System.out.println("The triangle is acute multifaceted");
                    }
                } else if (angleA > 90 || angleB > 90 || angleC > 90){
                    System.out.println("The triangle is obtuse");
                    if (sideA == sideB || sideA == sideC || sideB == sideC){
                        System.out.println("The triangle is obtuse isosceles");
                    } else {
                        System.out.println("The triangle is obtuse multifaceted");
                    }
                } else if (sideA == sideB && sideB == sideC){
                    System.out.println("The triangle is equilateral");
                }
            } else {
                System.out.println("Enter angle values the sum of which is equal to 180");
            }
        }
         else {
            System.out.println("The triangle is NOT possible");
            System.out.println("Enter positive values for each angle!");
        }
    }

}
