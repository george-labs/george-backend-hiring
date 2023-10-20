import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private final WordCounter wordCounter = new WordCounter();

    @DisplayName("Given a text it returns the number of words")
    @Test
    public void wordCount(){
        String text = "Mary had two little lambs";
        long result = wordCounter.countWordsFromText(text);
        assertEquals(5, result);
    }

    @DisplayName("Given a text with numbers or wrong characters the words should not be counted")
    @Test
    public void wordCountWithNumbers(){
        String text = "Mary2 had a little l7";
        long result = wordCounter.countWordsFromText(text);
        assertEquals(2, result);
    }

    @DisplayName("Given a text with special characters the words should not be counted")
    @Test
    public void wordCountWithSpecialCharacter(){
        String text = "Mary2 had, a little l7";
        long result = wordCounter.countWordsFromText(text);
        assertEquals(1, result);
    }

    @DisplayName("Given a text with a stop word then the stop word should not be counted ")
    @Test
    public void wordCountWithStopWords(){
        String text = "Mary had a little lamb";
        long result = wordCounter.countWordsFromText(text);
        assertEquals(4, result);
    }

    @DisplayName("Given an input file then the words in the file are counted")
    @Test
    public void wordCountFromFileInput(){
        try {
            File tmpfile = File.createTempFile("testFile", ".txt");
            tmpfile.deleteOnExit();
            FileWriter fw = new FileWriter(tmpfile);
            fw.write("Mary has a little lamb");
            fw.close();
            long numberOfWords = wordCounter.countWordsFromFile(tmpfile.getPath());
            assertEquals(4, numberOfWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
