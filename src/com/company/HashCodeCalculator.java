package com.company;

/**
 * Created by IDEA on 27/01/15.
 */
public class HashCodeCalculator {
    private int code = 1;
    public HashCodeCalculator takeIn(double x) {
        code = (int) Math.ceil(code * 9.97 + x);
        return this;
    }

    public int getCode() {
        return code;
    }
}
