package app;

import model.WordAnalyzer;
import model.WordAnalyzerFactory;
import model.WordCounterFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WordAnalyzerTest {

    private WordAnalyzerFactory analyzerFactory;

    @BeforeEach
    public void setUp(){
        String stopWordsFilePath = "test_stopwords.txt";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(stopWordsFilePath);
        assertNotNull(inputStream, "Test stop words file not found: "+stopWordsFilePath);
        analyzerFactory = new WordCounterFactory(inputStream);
    }

    @AfterEach
    public void tearDown(){
        analyzerFactory = null;
    }

    private WordAnalyzer creatWordAnalyzer(String input){
        return analyzerFactory.createWordAnalyzer(input);
    }

    private void assertWordCount(String input, long expectedWordCount){
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.countWords();
        assertEquals(expectedWordCount, wordCount);

    }

    @Test
    public void testCreateWordAnalyzerWithEmptyInput(){
        assertWordCount("", 0);
    }

    @Test
    public void testCreateWordAnalyzerWithNonEmptyInputWithStopWord(){
        assertWordCount("Mary had a little lamb", 4);
    }

    @Test
    public void testCreateWordAnalyzerWithSingleWord(){
        assertWordCount("Hello", 1);
    }

    @Test
    public void testCreateWordAnalyzerWithSingleStopWord(){
        assertWordCount("the", 0);
    }

    @Test
    public void testCreateWordAnalyzerWithSpecialChars(){
        assertWordCount("He said hello!", 2);
    }

    @Test
    public void testCreateWordAnalyzerWithSpecialCharsWithStopWord(){
        assertWordCount("He said the hello!", 2);
    }

    @Test
    public void testCreateWordAnalyzerWithSpecialCharsAndNumeric(){
        assertWordCount("He said hello!      3CC      ??word   ;;bye  end", 4);
    }

    @Test
    public void testCreateWordAnalyzerWithSpecialCharsAndNumericWithStopWord(){
        assertWordCount("He said the hello!      3CC      ??word   ;;bye  a end off", 4);
    }

    @Test
    public void testCreateWordAnalyzerWithMultipleLines(){
        assertWordCount( "Line 1\nLine 2\nLine 3", 3);
    }

    @Test
    public void testCreateWordAnalyzerWithMultipleLinesWithStopWords(){
        assertWordCount( "Line 1\noff\nLine 2\nLine 3\n the", 3);
    }

    @Test
    public void testCreateWordAnalyzerWithMixedCasingWithStopWord(){
        assertWordCount( "This Is a StRiNg", 3);
    }

    @Test
    public void testCreateWordAnalyzerWithStopWords(){
        assertWordCount( null, 0);
    }
}
