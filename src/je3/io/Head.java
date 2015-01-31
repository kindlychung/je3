package je3.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IDEA on 29/01/15.
 */
public class Head {
    public static String[] headLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] lines = new String[10];
        String line;
        int nLine = 0;
        while((line = reader.readLine()) != null) {
            lines[nLine++] = line;
            if(nLine >= 10) {
                break;
            }
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            throw new IllegalArgumentException();
        }
        String[] lines = headLines(args[0]);
        for(String line : lines) {
            if(!line.isEmpty()) {
                System.out.println(line);
            }
        }
    }

}
