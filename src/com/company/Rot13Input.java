package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IDEA on 26/01/15.
 */
public class Rot13Input {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            System.out.print("> ");
            String line = in.readLine();
            if(line.toLowerCase().equals("quit")) break;
            StringBuffer buf = new StringBuffer(line);
            for(int i=0; i<buf.length(); i++) {
                buf.setCharAt(i, rot13(buf.charAt(i)));
            }
            System.out.println(buf);
        }
    }

    private static char rot13(char c) {
        if((c >= 'a') && (c <= 'z')) {
            c += 13;
            if(c > 'z') {
                c -= 26;
            }
        }
        if((c >= 'A') && (c <= 'Z')) {
            c += 13;
            if(c > 'Z') {
                c -= 26;
            }
        }
        return c;
    }
}
