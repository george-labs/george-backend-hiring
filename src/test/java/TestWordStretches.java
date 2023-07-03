import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestWordStretches {

    WordCounter wordCounter = new WordCounterImpl();

    @Test
    public void testTwoWords() {
        String inputString = "foo bar";
        int expectedNum = 2;

        testWordCountFromGivenInput(inputString, expectedNum);
    }

    @Test
    public void testWithTab() {
        String inputString = "foo\tbar \tasd";
        int expectedNum = 3;

        testWordCountFromGivenInput(inputString, expectedNum);
    }

    @Test
    public void testWithBlankSpace() {
        String inputString = "    word         word      ";
        int expectedNum = 2;

        testWordCountFromGivenInput(inputString, expectedNum);
    }

    @Test
    public void testEmptyString() {
        String inputString = "";
        int expectedNum = 0;



        assertThrows(NoSuchElementException.class, () -> {
            testWordCountFromGivenInput(inputString, expectedNum);
        });
    }

    @Test
    public void testWithNumberInWord() {
        String inputString = "wo3d";
        int expectedNum = 0;

        testWordCountFromGivenInput(inputString, expectedNum);
    }


    @Test
    public void testWithSpecialCharacter() {
        String inputString = "    word       word        wor$d";
        int expectedNum = 2;

        testWordCountFromGivenInput(inputString, expectedNum);
    }

    @Test
    public void testWithWordOfOnlyNumbers() {
        String inputString = " 234 234 !!! word";
        int expectedNum = 1;

        testWordCountFromGivenInput(inputString, expectedNum);
    }

    @Test
    public void testWithPunctuation() {
        String inputString = "word, word. word? word! world";
        int expectedNum = 1;

        testWordCountFromGivenInput(inputString, expectedNum);
    }

    private void testWordCountFromGivenInput(String inputString, int expectedNum) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        int numberOfWords = wordCounter.countWords();
        assertEquals(expectedNum, numberOfWords);
        System.setIn(stdin);
    }

}
