package com.homework.lecture7_1_7_2;

public class MyClass {
    public static void main(String[] args) {
        Car car = new Car();
        Car car1 = new Car("Mercedes", 2000, 150, true);
        Car car2 = new Car("Audi", "black", false);
        Car car3 = new Car("Citroen", "blue", 2005, 120);
        Car car4 = new Car("Renault", 2015, 140, true);

        System.out.println(car);
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);

    }
}
