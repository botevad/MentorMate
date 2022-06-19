package com.homeworklecture9.ooppractice;

public class American extends Person{
    public American(String name, String sex, String language, String religion, String job, String nationality, String pin, String countryOfResidence) {
        super(name, sex, "English", "Catholic", job, "American", pin, countryOfResidence);
    }

    public boolean isAdult() {
        if (getAge() >= 21){
            System.out.printf("%s is Adult.\n", getName());
            return true;
        } else {
            System.out.printf("%s is NOT Adult.\n", getName());
            return false;
        }
    }

    public void sayHello() {
        System.out.printf("Hi, my name is %s\n", getName());
    }

    public void playsAmericanFootball() {
        System.out.printf("%s plays American Football\n", getName());
    }

    public void drinkWineHeavily(){

    }


}
