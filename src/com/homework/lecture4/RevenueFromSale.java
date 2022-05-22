package com.homework.lecture4;

import java.util.Scanner;

public class RevenueFromSale {
    public static void main(String[] args) {
        double unitPrice;
        int productQuantity;
        double revenue;
        double discount;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the quantity of the product, you'd like to purchase:");
        productQuantity = scanner.nextInt();

        System.out.println("Please enter unit price:");
        unitPrice = scanner.nextDouble();

        revenue = unitPrice * productQuantity;

        if (productQuantity > 0 && productQuantity < 100 ){
            System.out.println("The revenue from sale is: " + revenue + "$");
        } else if (productQuantity >= 100 && productQuantity <= 120){
            discount = revenue * 0.15;
            revenue = revenue - discount;
            System.out.println("The revenue from sale is: " + revenue + "$");
            System.out.println("Discount: " + discount + "$" + "(15.0 %)");
        } else if (productQuantity > 120){
            discount = revenue * 0.2;
            revenue = revenue - discount;
            System.out.println("The revenue from sale is: " + revenue + "$");
            System.out.println("Discount: " + discount + "$" + "(20.0%)");
        } else if (productQuantity <= 0 || unitPrice <= 0) {
            System.out.println("Please enter a valid quantity and unit price number");
        }
    }
}
