package application.text;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class TextTest {

    @Test
    void calculateWordsInSentenceWhenSentenceHaveFiveWordsAndStopWordsIsEmpty() {
        // given
        final String word = "Mary had a little lamb";

        // when
        final Long result = new Text(word).calculateWordsInText(new ArrayList<>());

        // then
        assertEquals(5, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveFiveWordsAndOneIsInStopWords() {
        // given
        final String word = "Mary had a little lamb";

        // when
        final Long result = new Text(word).calculateWordsInText(of("had"));

        // then
        assertEquals(4, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveFiveWordsAndNumbersAndStopWordsIsEmpty() {
        // given
        final String word = "Mary1 had a little lamb 123";

        // when
        final Long result = new Text(word).calculateWordsInText(new ArrayList<>());

        // then
        assertEquals(4, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveNoWordsAndStopWordsIsEmpty() {
        // given
        final String word = "Mary1";

        // when
        final Long result = new Text(word).calculateWordsInText(new ArrayList<>());

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveOnlyWordsFromStopWords() {
        // given
        final String word = "Mary";

        // when
        final Long result = new Text(word).calculateWordsInText(of("Mary"));

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveEmptySpaceAndStopWordsIsEmpty() {
        // given
        final String word = " ";

        // when
        final Long result = new Text(word).calculateWordsInText(new ArrayList<>());

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveEmptySpaceAndStopWordsIsNotEmpty() {
        // given
        final String word = " ";

        // when
        final Long result = new Text(word).calculateWordsInText(of("a"));

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveEmptyStringAndStopWordsIsEmpty() {
        // given
        final String word = "";

        // when
        final Long result = new Text(word).calculateWordsInText(new ArrayList<>());

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceHaveEmptyStringAndStopWordsIsNotEmpty() {
        // given
        final String word = "";

        // when
        final Long result = new Text(word).calculateWordsInText(of("a"));

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceIsNullAndStopWordsIsEmpty() {
        // given

        // when
        final Long result = new Text(null).calculateWordsInText(new ArrayList<>());

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateWordsInSentenceWhenSentenceIsNullAndStopWordsIsNotEmpty() {
        // given

        // when
        final Long result = new Text(null).calculateWordsInText(of("a"));

        // then
        assertEquals(0, result);
    }

    @Test
    void calculateUniqueWordsInText() {
        // given
        final String text = "a b cd 1e b";

        // when
        final Long result = new Text(text).calculateUniqueWordsInText(of("a"));

        // then
        assertEquals(1, result);
    }

    @Test
    void calculateUniqueWordsInTextWhenNoneIsUniq() {
        // given
        final String text = "a b  1e b";

        // when
        final Long result = new Text(text).calculateUniqueWordsInText(of("a"));

        // then
        assertEquals(0, result);
    }
}