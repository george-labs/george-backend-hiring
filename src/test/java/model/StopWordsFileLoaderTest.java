package model;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StopWordsFileLoaderTest {

    private InputStream createInputStream(String content){
        return new ByteArrayInputStream(content.getBytes());
    }

    @Test
    public void testLoadStopWordsWithValidInput() throws IOException {

        String input = "the\na\non\noff";
        InputStream inputStream = createInputStream(input);

        StopWordsFileLoader stopWordsFileLoader = new StopWordsFileLoader(inputStream);
        Set<String> expectedStopWords = new HashSet<>();
        expectedStopWords.add("the");
        expectedStopWords.add("a");
        expectedStopWords.add("on");
        expectedStopWords.add("off");

        Set<String> loadStopWords = stopWordsFileLoader.getStopWords();
        assertNotNull(loadStopWords);
        assertEquals(expectedStopWords, loadStopWords);

    }

    @Test
    public void testLoadStopWordsWithEmptyInput() throws IOException {
        String input = "";
        InputStream inputStream = createInputStream(input);

        StopWordsFileLoader stopWordsFileLoader = new StopWordsFileLoader(inputStream);
        Set<String> loadedStopWords = stopWordsFileLoader.getStopWords();

        assertNotNull(loadedStopWords);
        assertEquals(0, loadedStopWords.size());
    }

    @Test
    public void testLoadStopWordsWithNULLInput() {
        InputStream inputStream = null;
        assertThrows(IOException.class, ()->new StopWordsFileLoader(inputStream));
    }

}
