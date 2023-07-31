package app;

import model.WordAnalyzer;
import model.WordAnalyzerFactory;
import model.WordCounterFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JavaApplicationTest {

    private WordAnalyzerFactory analyzerFactory;

    @BeforeEach
    public void setUp(){
        analyzerFactory = new WordCounterFactory();
    }

    @AfterEach
    public void tearDown(){
        analyzerFactory = null;
    }

    private WordAnalyzer creatWordAnalyzer(String input){
        return analyzerFactory.createWordAnalyzer(input);
    }

    @Test
    public void testCreateWordAnalyzerWithEmptyInput(){

        String input = "";
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.countWords();
        assertEquals(0, wordCount);
    }

    @Test
    public void testCreateWordAnalyzerWithNonEmptyInput(){

        String input = "Mary had a little lamb";
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.countWords();
        assertEquals(5, wordCount);
    }

    @Test
    public void testCreateWordAnalyzerWithSingleWord(){

        String input = "Hello";
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.countWords();
        assertEquals(1, wordCount);
    }

    @Test
    public void testCreateWordAnalyzerWithSpecialChars(){

        String input = "He said hello!";
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.countWords();
        assertEquals(2, wordCount);
    }

    @Test
    public void testCreateWordAnalyzerWithSpecialCharsAndNumeric(){

        String input = "He said hello!      3CC      ??word   ;;bye  end";
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.countWords();
        assertEquals(3, wordCount);
    }

    @Test
    public void testCreateWordAnalyzerWithMultipleLines(){

        String input = "Line 1\nLine 2\nLine 3";
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.countWords();
        assertEquals(3, wordCount);
    }

    @Test
    public void testCreateWordAnalyzerWithMixedCasing(){

        String input = "This Is a StRiNg";
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.countWords();
        assertEquals(4, wordCount);
    }

    @Test
    public void testCreateWordAnalyzerWithInputNull(){

        String input = null;
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.countWords();
        assertEquals(0, wordCount);
    }
}
