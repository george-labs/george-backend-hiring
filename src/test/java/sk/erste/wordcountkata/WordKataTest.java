package sk.erste.wordcountkata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordKataTest {

    @Test
    public void testProcess_fromFile() throws FileNotFoundException {
        WordKata wordKata = new WordKata(new InputTextReader("mytext_test.txt"));
        assertEquals(4, wordKata.countWords());
    }

    @Test
    public void testProcess_emptyFile() throws FileNotFoundException {
        WordKata wordKata = new WordKata(new InputTextReader("mytext_test_empty.txt"));
        assertEquals(0, wordKata.countWords());
    }

    @Test
    public void testProcess_whenFileNotExist() {
        WordKata wordKata = new WordKata(new InputTextReader("mytext_test_missing.txt"));
        assertThrows(FileNotFoundException.class, wordKata::countWords);
    }

    @Test
    public void testProcess_fromConsole() throws FileNotFoundException {
        System.setIn(new ByteArrayInputStream("Mary had a little lamb".getBytes()));
        WordKata wordKata = new WordKata(new InputTextReader(null));
        assertEquals(4, wordKata.countWords());
    }
}
