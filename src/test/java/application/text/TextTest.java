package application.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextTest {

    @Test
    void calculateWordsInSentenceWhenSentenceHaveFiveWords() {
        // given
        final String word = "Mary had a little lamb";

        // when
        final Long result = new Text(word).calculateWordsInSentence();

        // then
        assertEquals(5, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveFiveWordsAndNumbers() {
        // given
        final String word = "Mary1 had a little lamb 123";

        // when
        final Long result = new Text(word).calculateWordsInSentence();

        // then
        assertEquals(4, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveNoWords() {
        // given
        final String word = "Mary1";

        // when
        final Long result = new Text(word).calculateWordsInSentence();

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveEmptySpace() {
        // given
        final String word = " ";

        // when
        final Long result = new Text(word).calculateWordsInSentence();

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveEmptyString() {
        // given
        final String word = "";

        // when
        final Long result = new Text(word).calculateWordsInSentence();

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceIsNull() {
        // given

        // when
        final Long result = new Text(null).calculateWordsInSentence();

        // then
        assertEquals(0, result);
    }

}