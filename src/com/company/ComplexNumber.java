package com.company;

/**
 * Created by IDEA on 26/01/15.
 */
public class ComplexNumber implements Comparable {
//public class ComplexNumber {

    private double x, y;

    public ComplexNumber(double real, double imaginary) {
        this.x = real;
        this.y = imaginary;
    }

    @Override
    public String toString() { return String.format("(%f, %f)", x, y); }

    public double real() { return x; }

    public double imaginary() { return y; }

    public double magnitude() { return Math.sqrt(x*x + y*y); }

    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.x + b.x, a.y + b.y);
    }

    public ComplexNumber add(ComplexNumber a) {
        return new ComplexNumber(x + a.x, y + a.y);
    }

    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.x * b.x - a.y * b.y, a.x * b.y + a.y * b.x);
    }

    public ComplexNumber multiply(ComplexNumber a) {
        return new ComplexNumber(a.x * x - a.y * y, a.x * y + a.y * x);
    }

    public boolean equals (ComplexNumber other) {
        return other.x == x && other.y == y;
    }


    @Override
    public int compareTo(Object o) {
        ComplexNumber other = (ComplexNumber) o;
        double diff = magnitude() - other.magnitude();
        if(diff < 0.0)  {
            return -1;
        } else if(diff == 0.0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int hashCode() {
        HashCodeCalculator hashCodeCalculator = new HashCodeCalculator();
        hashCodeCalculator.takeIn(x).takeIn(y);
        return hashCodeCalculator.getCode();
    }

}
