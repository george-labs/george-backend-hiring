import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWordStretches {


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

        testWordCountFromGivenInput(inputString, expectedNum);
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
        WordCounter wordCounter = new WordCounterImpl();

        int numberOfWords = wordCounter.countWords(inputString);
        assertEquals(expectedNum, numberOfWords);
    }

}
