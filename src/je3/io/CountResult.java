package je3.io;

/**
 * Created by IDEA on 31/01/15.
 */
public class CountResult {
    private final long nChars;
    private final long nWords;
    private final long nLines;

    public CountResult(long nChars, long nWords, long nLines) {
        this.nChars = nChars;
        this.nWords = nWords;
        this.nLines = nLines;
    }

    public long getnChars() {
        return nChars;
    }

    public long getnWords() {
        return nWords;
    }

    public long getnLines() {
        return nLines;
    }
}
