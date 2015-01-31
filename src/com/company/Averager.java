package com.company;

/**
 * Created by IDEA on 26/01/15.
 */
public class Averager {
    private int n = 0;
    private double sum = 0.0;
    private double sumOfSquares = 0.0;

    public void addDatum(double x) {
        n++;
        sum += x;
        sumOfSquares += x * x;
    }

    public double getAverage() { return sum / n; }

    public double getStandardDeviation() {
        return Math.sqrt((sumOfSquares - sum * sum / n) / n);
    }

    public int getN() {
        return n;
    }

    public double getSum() {
        return sum;
    }

    public double getSumOfSquares() {
        return sumOfSquares;
    }

    public void reset() {
        n = 0;
        sum = 0.0;
        sumOfSquares = 0.0;
    }

    public static class Test {
        public static void main(String[] args) {
            Averager a = new Averager();
            for(int i = 1; i <= 100; i++) {
                a.addDatum(i);;
            }
            System.out.printf("Average: %f", a.getAverage());
        }
    }
}
