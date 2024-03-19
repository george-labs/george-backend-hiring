package interview.business;

import interview.output.WordCountOutput;
import interview.reader.ConsoleInputReader;
import interview.reader.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author : Xenofon Zinoviou
 */
class WordCounterTest {

    private InputReader inputReader;

    private WordCounter testClass;

    @Test
    void test_givenValidInput_shouldReturnCorrectCount() {
        String text = "Mary had a little lamb";

        final WordCountOutput output = testRunWordCount(text);

        Assertions.assertEquals(5, output.getTotalWords());
    }

    @Test
    void test_givenValidInputWithIncorrectCharacterWord_shouldSkipIncorrectWord() {
        String text = "Mary had %R a little lamb";

        final WordCountOutput output = testRunWordCount(text);

        Assertions.assertEquals(5, output.getTotalWords());
    }

    @Test
    void test_givenValidInputWithSplitterUsingWord_shouldNotSkipWord() {
        String text = "Mary had e! a little lamb";

        final WordCountOutput output = testRunWordCount(text);

        Assertions.assertEquals(6, output.getTotalWords());
    }


    private InputStream getInputStream(String text) {
        return new ByteArrayInputStream(text.getBytes());
    }


    private WordCountOutput testRunWordCount(String text) {
        inputReader = new ConsoleInputReader(getInputStream(text));
        testClass = new WordCounter(inputReader);

        return testClass.processInput();
    }
}
