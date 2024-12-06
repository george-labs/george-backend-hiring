package com.erste.mm.service;

import com.erste.mm.model.UniqueCount;
import com.erste.mm.model.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordServiceTest {

    private final String STOP_WORDS_FILE = "stopwords.txt";

    private final String TEST_NON_SPECIAL_WORD = "testTest";
    private final String TEST_SPECIAL_WORD = "testTest1";

    @Test
    void testWordServiceCanFilterOutSpecialCharacterWords() {
        List<Word> words = WordService.filterWords(TEST_NON_SPECIAL_WORD + " " + TEST_SPECIAL_WORD);

        Assertions.assertEquals(1, words.size());
    }

    @Test
    void testStopWordsParametric() {
        // given
        final String STOPPED_WORD = "stop";
        List<String> stopWords = List.of(STOPPED_WORD);
        List<Word> words = List.of(new Word("testWord"), new Word("2"), new Word(STOPPED_WORD));

        // when
        UniqueCount count = WordService.countOnlyNonStoppedWords(words, stopWords);

        // then
        Assertions.assertEquals(2, count.getCount());
    }

    @Test
    void testValidNonStoppedWordsCountMatches() {
        final String MANUAL_INPUT = "firstWord second1nvlaid the";
        UniqueCount counted = WordService.countWordsWithoutStoppedWords(MANUAL_INPUT, STOP_WORDS_FILE);

        Assertions.assertEquals(1, counted.getCount());
    }

    @Test
    void testCanCountWordsAsListOfStringWords() {
        List<String> testWords = List.of("testWord", "testWord2", "testWord3", "qwer");
        UniqueCount counted = WordService.countWordsWithoutStoppedWords(testWords, STOP_WORDS_FILE);

        Assertions.assertEquals(2, counted.getCount());
    }

    @Test
    void testCanCountAverageWordLength() {
        List<Word> testWords = List.of(new Word("testWord"), new Word("2"), new Word("q"), new Word("q-p"));

        double averageLength = WordService.countAverageLength(testWords);

        Assertions.assertEquals(3.25, averageLength);
    }

    @Test
    void testCanCountNonRepeatingWords() {
        List<Word> testWords = List.of(new Word("testWord"), new Word("2"), new Word("testWord"), new Word("q-p"));

        long counted = WordService.countDistinctWords(testWords);

        Assertions.assertEquals(3, counted);
    }

    @Test
    void testCanCountEmptyWOrdsAsZeroRepeating() {
        long countedEmpty = WordService.countDistinctWords(List.of());

        Assertions.assertEquals(0, countedEmpty);
    }
}
