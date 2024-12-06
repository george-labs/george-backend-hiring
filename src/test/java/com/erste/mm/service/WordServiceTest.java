package com.erste.mm.service;

import com.erste.mm.model.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordServiceTest {

    private final String TEST_NON_SPECIAL_WORD = "testTest";
    private final String TEST_SPECIAL_WORD = "testTest1";

    @Test
    void testWordServiceCanFilterOutSpecialCharacterWords() {
        List<Word> words = WordService.countWords(TEST_NON_SPECIAL_WORD + " " + TEST_SPECIAL_WORD);

        Assertions.assertEquals(1, words.size());
    }

    @Test
    void testStopWordsParametric() {
        // given
        final String STOPPED_WORD = "stop";
        List<String> stopWords = List.of(STOPPED_WORD);
        List<Word> words = List.of(new Word("testWord"), new Word("2"), new Word(STOPPED_WORD));

        // when
        long count = WordService.countOnlyNonStoppedWords(words, stopWords);

        // then
        Assertions.assertEquals(2, count);
    }

    @Test
    void testValidNonStoppedWordsCountMatches() {
        final String MANUAL_INPUT = "firstWord second1nvlaid the";
        long counted = WordService.countWordsWithoutStoppedWords(MANUAL_INPUT, "stopwords.txt");

        Assertions.assertEquals(1, counted);
    }
}
