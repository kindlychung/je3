package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IDEA on 26/01/15.
 */
public class FactQuoter {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            System.out.print("FactQuoter> ");
            String line = in.readLine();
            if((line == null) || line.toLowerCase().equals("quit")) break;
            try {
                int x = Integer.parseInt(line);
                System.out.println(x + "! = " + Factorial4.factorial(x));
            }
            catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }
}
