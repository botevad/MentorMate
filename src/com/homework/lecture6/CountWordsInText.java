package com.homework.lecture6;

import java.util.Scanner;

import static java.awt.SystemColor.text;

public class CountWordsInText {
    public static int countWords(String text) {
        String[] words = text.split(" ");
        return words.length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a text: ");
        String str = in.nextLine();
        System.out.println("The text has " + countWords(str));
    }
}
