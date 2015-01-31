package com.company;

import java.io.File;

/**
 * Created by IDEA on 27/01/15.
 */
public class Delete {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Usage: java Delete <file>");
            System.exit(0);
        }
        try {
            delete(args[0]);
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void delete(String filename) {
        File f = new File(filename);
        if(!f.exists()) fail("no such file: " + filename);
        if(!f.canWrite()) fail("write protected: " + filename);
        if(f.isDirectory()) {
            String[] files = f.list();
            if(files.length > 0) {
                fail("dir not empty: " + filename);
            }
        }
        boolean success = f.delete();
        if(!success) fail("deletion failed.");
    }

    protected static void fail(String msg) throws IllegalArgumentException {
        throw new IllegalArgumentException(msg);
    }

}
