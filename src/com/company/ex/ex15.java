package com.company.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by IDEA on 26/01/15.
 */
//Exercise 1-5. The SortNumbers class shows how you can sort an array of doubles. Write a program that uses this class to sort an array of 100 floating-point numbers. Then, interactively prompt the user for numeric input, and display the next larger and next smaller number from the array. You should use an efficient binary search algorithm to find the desired position in the sorted array.
public class ex15 {
    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            // print prompt
            System.out.print("> ");
            // get input
            String line = buf.readLine();
            // break if user type quit
            if(line.equals("quit")) break;
            int entry = Integer.parseInt(line);
            // put user's entry into the list with right order
            if(list.isEmpty()) {
                list.add(entry);
            }
            else {
                int insertIndex = 0;
                boolean insertIndexFound = false;
                for(int i = 0; i < list.size(); i++) {
                    if(entry <= list.get(i)) {
                        System.out.println(entry + " <= " + list.get(i));
                        insertIndexFound = true;
                        insertIndex = i;
                        break;
                    }
                }
                if(insertIndexFound) {
                    list.add(insertIndex, entry);
                }
                else {
                    list.add(entry);
                }
            }
            // print list
            printList();
        }
    }

    private static void printList() {
        for(Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
