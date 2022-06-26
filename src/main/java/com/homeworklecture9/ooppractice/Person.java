package com.homeworklecture9.ooppractice;

import java.time.LocalDate;


public class Person {
    private String name;
    private String sex;
    private String language;
    private String religion;
    private String job;
    private String nationality;
    private String pin;
    private LocalDate dateOfBirth;
    private short age;
    private String countryOfResidence;

    public Person(String name, String sex, String language, String religion, String job, String nationality, String pin, String countryOfResidence) {
        this.name = name;
        this.language = language;
        this.religion = religion;
        this.job = job;
        this.nationality = nationality;

        this.countryOfResidence = countryOfResidence;

        try {
            if ("male".equalsIgnoreCase(sex) || "female".equalsIgnoreCase(sex)) {
                this.sex = sex;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal sex option is added!");
        }

        try {
            if (pin.length() == 10 && pin.matches("[0-9]+")) {
                this.pin = pin;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal PIN option is added!");
        }

        int yearOfBirth = 0;
        int monthOfBirth = 0;
        int dayOfBirth = 0;

        try {
            yearOfBirth = Integer.parseInt(pin.substring(0, 2));
            monthOfBirth = Integer.parseInt(pin.substring(2, 4));
            dayOfBirth = Integer.parseInt(pin.substring(4, 6));
        } catch (NumberFormatException ne){
            System.out.println("You have typed an incorrect PIN number: " + ne.getMessage() );
        }

        int centuryCheck = Integer.parseInt(pin.substring(2,3));
        if (centuryCheck == 4 || centuryCheck == 5){
            yearOfBirth += 2000;
            //yearOfBirth = Integer.parseInt("20" + pin.substring(0, 2));
            monthOfBirth -= 40;
        } else {
            yearOfBirth += 1900;
            //yearOfBirth = Integer.parseInt("19" + pin.substring(0, 2));
        }

        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.age = (short) (LocalDate.now().getYear() - yearOfBirth);
    }

    public void sayHello(){
        String hello;

        switch (getLanguage()) {
            case "Bulgarian":
                hello = "Здравей";
                break;

            case "Italian":
                hello = "Ciao";
                break;
            default:
                hello = "Hello";
        }
        System.out.printf("%s, my name is %s! \n", hello, getName());
    }

    public boolean celebrateEaster(){
        if("orthodox".contentEquals(getReligion().toLowerCase()) ||
        "catholic".contentEquals(getReligion().toLowerCase())){
            System.out.printf("%s celebrates Easter.\n", getName());
            return true;
        }else {
            System.out.printf("%s does not celebrate Easter.\n", getName());
            return false;
        }
    }

    public boolean isAdult(){
        if ("USA".equalsIgnoreCase(getCountryOfResidence())){
            if (getAge() >= 21){
                System.out.printf("%s is Adult.\n", getName());
                return true;
            } else {
                System.out.printf("%s is NOT Adult.\n", getName());
                return false;
            }
        } else {
            if (getAge() >= 18){
                System.out.printf("%s is Adult.\n", getName());
                return true;
            } else {
                System.out.printf("%s is NOT Adult.\n", getName());
                return false;
            }
        }
    }

    public boolean canTakeLoan(){
        if (isAdult() && getJob() != null){
            System.out.printf("%s can take a loan.\n", getName());
            return true;
        } else {
            System.out.printf("%s can't take a loan.\n", getName());
            return false;
        }
    }


    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getLanguage() {
        return language;
    }

    public String getReligion() {
        return religion;
    }

    public String getJob() {
        return job;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPin() {
        return pin;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public short getAge() {
        return age;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", language='" + language + '\'' +
                ", religion='" + religion + '\'' +
                ", job='" + job + '\'' +
                ", nationality='" + nationality + '\'' +
                ", pin='" + pin + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", countryOfResidence='" + countryOfResidence + '\'' +
                '}';
    }
}
