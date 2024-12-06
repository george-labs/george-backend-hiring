package com.erste.mm.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordTest {

    private final String TEST_NON_SPECIAL_WORD = "testTest";
    private final String TEST_SPECIAL_WORD = "testTest1";
    private final String TEST_SPECIAL_WORD2 = "testTest_";

    @Test
    void testCanTellWordWithoutSpecialCharacters() {
        Word word = new Word(TEST_NON_SPECIAL_WORD);

        Assertions.assertTrue(word.isLetteredWord());
    }

    @Test
    void testCanTellWordWithSpecialCharacters() {
        // given
        Word word = new Word(TEST_SPECIAL_WORD);
        Word anotherWord = new Word(TEST_SPECIAL_WORD2);

        // then
        Assertions.assertFalse(word.isLetteredWord());
        Assertions.assertFalse(anotherWord.isLetteredWord());
    }

    @Test
    void testRegexWordPatternCanHandleSpecialCharacters() {
        Word word = new Word("sat.");
        Word word2 = new Word("Humpty-Dumpty.");

        Assertions.assertTrue(word.isLetteredWord());
        Assertions.assertTrue(word2.isLetteredWord());
    }

}
