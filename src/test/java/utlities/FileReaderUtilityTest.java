package utlities;

import org.junit.jupiter.api.Test;
import wordcounter.utilities.FileReadingUtility;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileReaderUtilityTest {

    @Test
    public void testReadStopwordsForWordsPresentInFile(){
        Set<String> stopwords = FileReadingUtility.readStopwords();

        assertTrue(stopwords.contains("the"));
        assertTrue(stopwords.contains("a"));
        assertTrue(stopwords.contains("on"));
        assertTrue(stopwords.contains("off"));
    }

    @Test
    public void testReadStopwordsForWordsNotPresentInFile(){
        Set<String> stopwords = FileReadingUtility.readStopwords();

        assertFalse(stopwords.contains("small"));
    }

}
