package je3.io;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by IDEA on 31/01/15.
 */
// todo: Make it generic
public class RingBuffer {
    private final int limit;
    private final String[] data;
    // counter counts the number of data points that have been collected.
    // it's also the index of next data input
    private int counter = 0;

    public RingBuffer(int limit) {
        this.limit = limit;
        this.data = new String[limit];
    }

    public void collect(String line) {
        data[counter++ % limit] = line;
    }

    public List<String> contents() {
        return IntStream.range(counter < limit ? 0 : counter - limit, counter)
                .mapToObj(index -> data[index %limit])
                .collect(Collectors.toList());
    }
}
