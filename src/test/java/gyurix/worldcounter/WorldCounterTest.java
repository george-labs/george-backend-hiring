package gyurix.worldcounter;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WorldCounterTest {
    @Test
    public void testIteration1NoInput() {
        WorldCounter wc = new WorldCounter();
        NullPointerException exception = assertThrows(NullPointerException.class, wc::doWork);
        assertEquals("Input is null", exception.getMessage());
    }

    @Test
    public void testIteration1InvalidInput() {
        WorldCounter wc = new WorldCounter();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> wc.setInput("0"));
        assertEquals("Invalid input, only a-z, A-Z and whitespace is allowed", exception.getMessage());
    }

    @Test
    public void testIteration1NotComplete() {
        WorldCounter wc = new WorldCounter();
        wc.setInput("input");
        IllegalStateException exception = assertThrows(IllegalStateException.class, wc::getResult);
        assertEquals("Result is not complete", exception.getMessage());
    }

    @Test
    public void testIteration1ExampleInput() {
        WorldCounter wc = new WorldCounter();
        wc.setInput("Mary had a little lamb");
        wc.doWork();
        int result = wc.getResult();
        assertEquals(5, result);
    }

    @Test
    public void testIteration2ExampleInput() throws IOException {
        WorldCounter wc = new WorldCounter("stopwords.txt");
        wc.setInput("Mary had a little lamb");
        wc.doWork();
        int result = wc.getResult();
        assertEquals(4, result);
    }

    @Test
    public void testIteration2OnlyStopWordsCaseInsensitive() throws IOException {
        WorldCounter wc = new WorldCounter("stopwords.txt");
        wc.setInput("The a on off ON OFF");
        wc.doWork();
        int result = wc.getResult();
        assertEquals(0, result);
    }

    @Test
    public void testIteration2NullStopWordsFile() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new WorldCounter(null));
        assertEquals("stopwordsPath is null", exception.getMessage());
    }

    @Test
    public void testIteration2InvalidStopWordsFile() {
        NoSuchFileException exception = assertThrows(NoSuchFileException.class, () -> new WorldCounter("invalid.txt"));
        assertEquals("invalid.txt", exception.getMessage());
    }

    @Test
    public void testIteration2DoWorkTwice() throws IOException {
        WorldCounter wc = new WorldCounter("stopwords.txt");
        wc.setInput("Mary had a little lamb");
        wc.doWork();
        IllegalStateException exception = assertThrows(IllegalStateException.class, wc::doWork);
        assertEquals("Work is already complete", exception.getMessage());
    }

    @Test
    public void testIteration2NullInput() throws IOException {
        WorldCounter wc = new WorldCounter("stopwords.txt");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> wc.setInput(null));
        assertEquals("Invalid input, only a-z, A-Z and spaces are allowed", exception.getMessage());
    }
}
