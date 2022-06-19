package com.homework.lecture9;

public class Italian extends Person{
    public Italian(String name, String sex, String language, String religion, String job, String nationality, String pin, String countryOfResidence) {
        super(name, sex, "com.homework.lecture9.Italian", religion, job, "com.homework.lecture9.Italian", pin, countryOfResidence);
    }

    @Override
    public boolean isAdult() {
        if (getAge() >= 18){
            System.out.printf("%s is Adult.\n", getName());
            return true;
        } else {
            System.out.printf("%s is NOT Adult.\n", getName());
            return false;
        }
    }

    public void sayHello() {
        System.out.printf("Ciao, mi chiamo %s\n", getName());
    }

    public void drinks(){
        if (getNationality() == "com.homework.lecture9.Italian") {
            System.out.printf("%s drinks 45 bottles of wine per year per statistics!\n", getName());
        }else {
            System.out.printf("%s drinks wine moderately!\n", getName());
        }
    }
}
