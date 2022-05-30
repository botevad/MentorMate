package com.homework.lecture5;

import java.util.Collections;
import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        // Declaring linkedlist without any initial size
        LinkedList<Integer> ll = new LinkedList<Integer>();

        // Appending elements at the end of the list
        ll.add(1);
        ll.add(2);
        ll.add(3);

        System.out.println("The elements of the linked list before reversing: " + ll);
        // Collections.reverse method to reverse the list
        Collections.reverse(ll);
        System.out.println("The elements of the linked list after reversing: " + ll);
    }
}

