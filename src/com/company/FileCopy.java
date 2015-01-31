package com.company;

import java.io.*;

/**
 * Created by IDEA on 27/01/15.
 */
public class FileCopy {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("2 args required.");
            System.exit(0);
        }
        else {
            try {
                copy(args[0], args[1]);
            }
            catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void copy(String from_name, String to_name) throws IOException {
        File to_file = new File(to_name);
        File from_file = new File(from_name);
        if(!from_file.exists()) throw new IllegalArgumentException("not such file: " + from_name);
        if(!from_file.isFile()) throw new IllegalArgumentException("not a regular file: " + from_name);
        if(!from_file.canRead()) throw new IllegalArgumentException("not readable: " + from_name);
        if(to_file.isDirectory()) to_file = new File(to_file, from_file.getName());
        if(to_file.exists()) {
            if(!to_file.canWrite()) {
                abort("access to file denied: " + to_name);
            }
            System.out.print("Overwrite existing file? (y/N)");
            System.out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String response = in.readLine().toLowerCase();
            if(!response.equals("y") && !response.equals("n")) {
                abort("Not overwritten: " + to_file.getName());
            }
        }
        else {
            String parent = to_file.getParent();
            if(parent == null) {
                parent = System.getProperty("user.dir");
            }
            File dir = new File(parent);
            if(!dir.exists()) abort("destination folder does not exist: " + parent);
            if(!dir.canWrite()) abort("folder not writable: " + parent);
        }

        FileInputStream from = null;
        FileOutputStream to = null;
        try {
            from = new FileInputStream(from_file);
            to   = new FileOutputStream(to_file);
            byte[] buffer = new byte[4096];
            int bytes_read;
            while((bytes_read = from.read()) != -1) {
                to.write(buffer, 0, bytes_read);
            }
        }
        finally {
            if(to != null) {
                try {
                    to.close();
                }
                catch (IOException e) {;}
            }
            if(from != null) {
                try {
                    from.close();
                }
                catch (IOException e) {;}
            }
        }
    }

    private static void abort(String s) throws IOException {
        throw new IOException("FileCopy: " + s);
    }
}
