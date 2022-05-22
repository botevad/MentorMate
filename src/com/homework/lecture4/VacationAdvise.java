package com.homework.lecture4;

import java.util.Scanner;

public class VacationAdvise {
    public static void main(String[] args) {
        String vacationType;
        double budget;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of vacation would you prefer: Beach or Mountain?");
        vacationType = scanner.nextLine();
        System.out.println("Please enter budget per day per person:");
        budget = scanner.nextDouble();

        if (vacationType.equals("Beach")){
            if (budget <= 20){
                System.out.println("You can't afford to go on vacation :( ");
            } else if (budget <= 50) {
                System.out.println("Based on the the budget you're advised to have vacation in Bulgaria");
            } else {
                System.out.println("Based on the the budget you can afford to go on vacation abroad");
            }
        } else if (vacationType.equals("Mountain")){
            if (budget <= 15){
                System.out.println("You can't afford to go on vacation :( ");
            } else if (budget <= 30){
                System.out.println("Based on the the budget you're advised to have vacation in Bulgaria");
            } else {
                System.out.println("Based on the the budget you can afford to go on vacation abroad");
            }
        } else {
            System.out.println("There is no information about this type of vacation");
        }
    }
}
