package je3.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by IDEA on 28/01/15.
 */
public class WordList {
    RandomAccessFile f;
    long[] positions;

    public WordList(String filename) throws IOException {
        f = new RandomAccessFile(filename, "r");
        int numwords = f.readInt();
        positions = new long[numwords];
        for(int i = 0; i < numwords; i++) {
            positions[i] = f.readLong();
        }
    }

    public void close() throws IOException {
        if(f != null) f.close();
        f = null;
        positions = null;
    }

    public int size() {
        if(f == null) throw new IllegalArgumentException("already closed");
        return positions.length;
    }

    public String get(int i) throws IOException {
        if(f == null) throw new IllegalArgumentException("already closed");
        f.seek(positions[i]);
        return f.readUTF();
    }

    public static void main(String[] args) throws IOException {
        writeWords("words.data", args);
        WordList list = new WordList("words.data");
        for(int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
        list.close();
    }

    private static void writeWords(String filename, String[] words) {
    }
}
