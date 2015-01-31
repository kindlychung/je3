package com.company;

/**
 * Created by IDEA on 26/01/15.
 */
public class FactComputer {
    public static void main(String[] args) {
        try {
            int x = Integer.parseInt(args[0]);
            System.out.println(x + "! = " + Factorial4.factorial(x));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No args given.");
        }
        catch (NumberFormatException e) {
            System.out.println("Arg is not a number.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Bad arg: " + e.getMessage());
        }
    }
}
