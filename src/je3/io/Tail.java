package je3.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by IDEA on 29/01/15.
 */
public class Tail {
    public static String[] tailLines(String filename, int nLinesToRead) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "r");
        long lengthOfFile = randomAccessFile.length();
        long counterFromEnd = 1L;
        long newlineCounterGoal = nLinesToRead;
        int newlineCounter = 0;
        long tailPosition = 0L; // start of the end ;-)

        // If you want to get the last 10 lines,
        // and the last line ends with a newline, then you need to count back 11 newlines
        // if there is no trailing newline, then you only need to count back 10
        randomAccessFile.seek(lengthOfFile - 1L);
        char currentChar = (char) randomAccessFile.readByte();
        if(currentChar == '\n') {
            newlineCounterGoal++;
        }

        while(counterFromEnd <= lengthOfFile) {
            randomAccessFile.seek(lengthOfFile - counterFromEnd);
            if(randomAccessFile.readByte() == '\n') {
                newlineCounter++;
            }
            if(newlineCounter == newlineCounterGoal) {
                tailPosition = randomAccessFile.getFilePointer();
                break;
            }
            counterFromEnd++;
        }
        randomAccessFile.seek(tailPosition);

        String line;
        String[] lines = new String[nLinesToRead];
        int nLine = 0;
        while((line = randomAccessFile.readLine()) != null) {
            lines[nLine++] = line;
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            throw new IllegalArgumentException();
        }
        String[] lines = tailLines(args[0], 10);
        for(String line : lines) {
            if(line != null) {
                System.out.println(line);
            }
        }
    }
}
