package com.homework.lecture6;

import java.util.Scanner;

public class MiddleCharacterOfString1 {

    public static boolean getMiddleCharacterOfString1(String number){
        if(number.length()%2==1) {
            System.out.println("The middle character in the string: "+number.charAt(number.length()/2));
        }else if(number.length()%2==0) {
            System.out.println("The middle characters in the string: "+number.charAt(number.length()/2-1)+
                    " and "+number.charAt(number.length()/2));
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        String number = in.nextLine();
        System.out.println(getMiddleCharacterOfString1(number));
    }
}
