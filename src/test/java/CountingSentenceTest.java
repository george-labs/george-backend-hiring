
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
class CountingSentenceTest {
    private Sentence sentence;

    private StopWords stopWords;

    private FileReaderText fileReaderText;

    @BeforeEach
    void setUp() throws IOException {
        stopWords = new StopWords();
        fileReaderText = new FileReaderText();
        stopWords.setStopWords(fileReaderText.readingTxtFileConvertingToListOfString("stopwords.txt"));
        sentence = new Sentence(stopWords);
    }

    @Test
    void countingWordsInSentenceWithEmptySpacesAtBeginningTest() {

        assertEquals(1, sentence.countingWordsOnlyLetter("     word     "));
    }

    @Test
    void countingWordsWithoutEmptySpacesAndNumbersTest() {

        assertEquals(1, sentence.countingWordsOnlyLetter("word"));
    }

    @Test
    void countingWordsWithThreeWordInSentenceTest(){

        assertEquals(3, sentence.countingWordsOnlyLetter("word word word"));
    }

    @Test
    void countingWordsWithNumbersInSentenceTest() {

        assertEquals(2, sentence.countingWordsOnlyLetter("wor3d word word"));
    }
    @Test
    void countingWordsWithSpecialCasesTest(){

        assertEquals(1, sentence.countingWordsOnlyLetter("wo$$d word"));
    }

    @Test
    void countingWordsWithComasDotsAndQuestionMarksCasesTest(){

        assertEquals(1, sentence.countingWordsOnlyLetter("word. word, word? word! word"));
    }

    @Test
    void countingWordsWithEmptyStringCasesTest(){

        assertEquals(0, sentence.countingWordsOnlyLetter(""));
    }

    @Test
    void countingWordsExcludedStopWordsFromFileTest(){
        assertEquals(4, sentence.countingWordsOnlyLetter("Mary had a little lamb"));
    }
}
