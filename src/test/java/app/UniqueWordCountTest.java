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

public class UniqueWordCountTest {
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

    private void assertUniqueWordCount(String input, long expectedWordCount){
        WordAnalyzer wordAnalyzer = creatWordAnalyzer(input);

        assertNotNull(wordAnalyzer);
        long wordCount = wordAnalyzer.uniqueWords();
        assertEquals(expectedWordCount, wordCount);
    }

    @Test
    public void testCreateUniqueWordCountWithEmptyInput(){
        assertUniqueWordCount("", 0);
    }

    @Test
    public void testCreateUniqueWordCountWithNonEmptyInput(){
        assertUniqueWordCount("Mary had a little lamb", 4);
    }

    @Test
    public void testCreateUniqueWordCountWithHyphenAndPunctuations(){
        assertUniqueWordCount("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 7);
    }
    @Test
    public void testCreateUniqueWordWithMultipleLines(){
        assertUniqueWordCount( "Line 1\noff\nLine 2\nLine 3\n the", 1);
    }

    @Test
    public void testCreateUniqueWordWithMixedCasing(){
        assertUniqueWordCount( "This Is a StRiNg", 3);
    }

    @Test
    public void testCreateUniqueWordWithStopWords(){
        assertUniqueWordCount( null, 0);
    }
}
