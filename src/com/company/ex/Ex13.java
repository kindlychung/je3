package com.company.ex;

/**
 * Created by IDEA on 26/01/15.
 */
public class Ex13 {
    public static String substring(String s, int start, int end) {
        StringBuffer buf = new StringBuffer(s);
        return buf.substring(start, end).toString();
    }

    public static void main(String[] args) {
        String s = args[0];
        int start = Integer.parseInt(args[1]);
        int end = Integer.parseInt(args[2]);
        System.out.println(substring(s, start, end));
    }
}
