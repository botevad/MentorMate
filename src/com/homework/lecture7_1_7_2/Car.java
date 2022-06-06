package com.homework.lecture7_1_7_2;

public class Car {


    private String name = "N/A";
    private String color = "N/A";
    private int releaseYear = -1;
    private int horsePower = -1;
    private boolean secondHand = false;

    public Car(String name, String color, int releaseYear, int horsePower, boolean secondHand) {
        this.name = name;
        this.color = color;
        this.releaseYear = releaseYear;
        this.horsePower = horsePower;
        this.secondHand = secondHand;
    }

    public Car() {
    }


    public Car(String name, int releaseYear, int horsePower, boolean secondHand) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.horsePower = horsePower;
        this.secondHand = secondHand;
    }

    public Car(String name, String color, int releaseYear, int horsePower) {
        this.name = name;
        this.color = color;
        this.releaseYear = releaseYear;
        this.horsePower = horsePower;
    }

    public Car(String name, String color, boolean secondHand) {
        this.name = name;
        this.color = color;
        this.secondHand = secondHand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", releaseYear=" + releaseYear +
                ", horsePower=" + horsePower +
                ", secondHand=" + secondHand +
                '}';
    }
}
