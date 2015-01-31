package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by IDEA on 26/01/15.
 */

//public class Factorial4 {
//    protected static ArrayList table = new ArrayList();
//    static {
//        table.add(BigInteger.valueOf(1));
//    }
//    public static synchronized BigInteger factorial(int x) {
//        if(x < 0) {
//            throw new IllegalArgumentException("Negative x.");
//        }
//        for(int size = table.size(); size <= x; size++) {
//            // Why the casting?
//            BigInteger lastfact = (BigInteger) table.get(size - 1);
//            BigInteger nextfact = lastfact.multiply(BigInteger.valueOf(size));
//            table.add(nextfact);
//        }
//        return (BigInteger) table.get(x);
//    }
//}


public class Factorial4 {
    protected static ArrayList<BigInteger> table = new ArrayList();
    static {
        table.add(BigInteger.valueOf(1));
    }
    public static synchronized BigInteger factorial(int x) {
        if(x < 0) {
            throw new IllegalArgumentException("Negative x.");
        }
        for(int size = table.size(); size <= x; size++) {
            // Why the casting?
            BigInteger lastfact = table.get(size - 1);
            BigInteger nextfact = lastfact.multiply(BigInteger.valueOf(size));
            table.add(nextfact);
        }
        return  table.get(x);
    }
}
