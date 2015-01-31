package com.company.ex;

import java.util.ArrayList;

/**
 * Created by IDEA on 26/01/15.
 */
// Exercise 1-2. Each term of the Fibonacci series is formed by adding
// the previous two terms. What sort of series do you get if you add the previous three terms? Write a program to print the first 20 terms of this series.
public class Ex12 {
    public static ArrayList<Integer> table = new ArrayList<Integer>();
    static {
        table.add(0);
        table.add(1);
        table.add(2);
    }
    public static int fib3(int n) {
        for(int i = table.size(); i <= n; i++) {
            table.add(table.get(i-1) + table.get(i-2) + table.get(i-3));
        }
        return table.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fib3(5));
    }
}
