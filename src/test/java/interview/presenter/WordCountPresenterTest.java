package interview.presenter;

import interview.output.WordCountOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Xenofon Zinoviou
 */
class WordCountPresenterTest {

    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;
    private WordCountPresenter testClass;

    @BeforeEach
    public void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void test_givenValidInput_shouldPresentWordCount() {
        testClass = new WordCountPresenter();

        testClass.presentWordCount(WordCountOutput.of(5));

        assertEquals("Number of words: 5", outputStreamCaptor.toString());
    }

}
