import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {


    private final WordCount wordCount;
    private final FileReader fileReader;

    public WordCountTest() {

        this.fileReader = new FileReader();
        this.wordCount = new WordCountService(fileReader);

    }

    @Test
    void countWordsWithSpecialCharactersReturnsExpectedly() {

        int expectedResult = 2;
        List<String> words = TextUtil.getTrimmedAndSplitedWords("Mary had !@#@$");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithJustNumbersReturnsZero() {

        int expectedResult = 0;
        List<String> words = TextUtil.getTrimmedAndSplitedWords("11 22");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithEmptyStringReturnsZero() {

        int expectedResult = 0;
        List<String> words = TextUtil.getTrimmedAndSplitedWords("");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }


    @Test
    void countWordsWithNullInputReturnsZero() {

        int expectedResult = 0;
        List<String> words = TextUtil.getTrimmedAndSplitedWords(null);
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }


    @Test
    void countWordsWithMultipleSpacesReturnsExpectedWords() {

        int expectedResult = 4;
        List<String> words = TextUtil.getTrimmedAndSplitedWords("   Mary       had a little lamb  ");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithStopWordIgnoresStopWord() {

        int expectedResult = 4;
        List<String> words = TextUtil.getTrimmedAndSplitedWords("Mary had a little lamb");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }


    @Test
    void countWordsWithOnlyStopWordsReturnsZero() {

        int expectedResult = 0;
        List<String> words = TextUtil.getTrimmedAndSplitedWords("the a on off");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithUpperCaseStopWordReturnsExpectedly() {

        List<String> words = TextUtil.getTrimmedAndSplitedWords("Mary had A little lamb");
        int result = wordCount.countWords(words);

        int expectedResult = 4;
        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithNumbersIncludedCountsOnlyWords() {

        int expectedResult = 6;
        List<String> words = TextUtil.getTrimmedAndSplitedWords("Mary had a little lamb and 1 cow");
        int result = wordCount.countWords(words);

        assertEquals(expectedResult, result);
    }

    @Test
    void countWordsWithWordsFromFileReturnsExpectedly() throws Exception {

        List<String> wordsFromFile = fileReader.getWordsFromFile("words.txt");
        int result = wordCount.countWords(wordsFromFile);

        int expectedResult = 4;

        assertEquals(expectedResult, result);
    }
}
