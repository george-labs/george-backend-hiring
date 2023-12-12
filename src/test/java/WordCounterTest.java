import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordCounterTest {

    @Test
    public void GIVEN_sentence_WHEN_count_THEN_wordsCounted() {
        //GIVEN
        WordCounter wordCounter = new WordCounter();
        String sentence = "Hello World";
        long expectedCount = 2;

        //WHEN
        long actualCount = wordCounter.count(sentence);

        //THEN
        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void GIVEN_wordsWithSpecialCharacters_WHEN_count_THEN_countedOnlyRegularWords() {
        //GIVEN
        WordCounter wordCounter = new WordCounter();
        String sentence = "'Hello W0rld";
        long expectedCount = 0;

        //WHEN
        long actualCount = wordCounter.count(sentence);

        //THEN
        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void GIVEN_wordsWithStopwordUsed_WHEN_count_THEN_countedOnlyRegularWords() {
        //GIVEN
        WordCounter wordCounter = new WordCounter();
        String sentence = "'Hello the W0rld";
        long expectedCount = 0;

        //WHEN
        long actualCount = wordCounter.count(sentence);

        //THEN
        Assertions.assertEquals(expectedCount, actualCount);
    }

}