package com.company;

/**
 * Created by IDEA on 26/01/15.
 */
public class Seive {
    public static void main(String[] args) {
        int max = 100;
        try {
            max = Integer.parseInt(args[0]);
        }
        catch (Exception e) {}
        // max+1 is used here because we also consider 0
        boolean[] isprime = new boolean[max + 1];
        for(int i=0; i<=max; i++) isprime[i] = true;
        isprime[0] = isprime[1] = false;
        int n = (int) Math.ceil(Math.sqrt(max));
        // Take 49 for example, let S = {min(a,b) | ab = 49}
        // max(S) <= sqrt(49) = 7
        // This is true for all numbers <= 49
        for(int i=0; i<=n; i++) {
            if(isprime[i]) {
                for(int j=2*i; j<=max; j=j+i) isprime[j] = false;
            }
        }
        int largest;
        for(largest = max; !isprime[largest]; largest--);
    }
}
