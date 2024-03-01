import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountingWordsTest {

    @Test
    public void givenRightTextTest() {
        CountingWords countingWords = new CountingWords();
        String text = "Mary had a little lamb";

        var result = countingWords.countNumberOfWords(text);

        Assertions.assertEquals(5, result);
    }


    @Test
    public void givenWrongTextTest() {
        CountingWords countingWords = new CountingWords();
        String text = "text1 Strin.g Te!st";

        var result = countingWords.countNumberOfWords(text);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void givenNullTest() {
        CountingWords countingWords = new CountingWords();
        String text = null;

        var result = countingWords.countNumberOfWords(text);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void givenEmptyText() {
        CountingWords countingWords = new CountingWords();
        String text = "";

        var result = countingWords.countNumberOfWords(text);

        Assertions.assertEquals(0, result);
    }

}