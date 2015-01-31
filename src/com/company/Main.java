package com.company;

public class Main {
    public static void main(String[] args) {
        char[] a = "0123456789".toCharArray();
        // create a string from a char array
        String x = new String(a, 2, 3);
        System.out.println(x);
        System.out.println(Math.ceil(-0.001));
    }
}
