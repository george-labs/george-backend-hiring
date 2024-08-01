package com.george.interview.counter;

import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WordsCounterTest {

  private WordsCounter counter;

  @BeforeEach
  void setUp() {

    counter = new WordsCounter(new HashSet<>());
  }

  @Nested
  class CountWords {

    @Test
    void countWordsFromSingleWord() {

      var result = counter.countWords("Hello");
      Assertions.assertEquals(1, result.wordCount());
    }

    @Test
    void countWordsFromMultipleWord() {

      var result = counter.countWords("Hello dear friend from space");
      Assertions.assertEquals(5, result.wordCount());
    }

    @Test
    void countWordsInNullString() {

      var result = counter.countWords(null);
      Assertions.assertEquals(0, result.wordCount());
    }

    @Test
    void countWordsInEmptyString() {

      var result = counter.countWords("");
      Assertions.assertEquals(0, result.wordCount());
    }

    @Test
    void countWordsWithSpecificDelimitersString() {

      var result = counter.countWords("Hello4World\nHow\tAre-you");
      Assertions.assertEquals(5, result.wordCount());
    }
  }

  @Nested
  class CountUniqueWords {

    @Test
    void countEmptyArrayOfWords() {

      Assertions.assertEquals(0, counter.countUniqueWords(new String[] {}));
    }

    @Test
    void countAllUniqueWords() {

      Assertions.assertEquals(4, counter.countUniqueWords(new String[] {"a", "hello", "test", "test2"}));
    }

    @Test
    void allWordsAreTheSame() {

      Assertions.assertEquals(1, counter.countUniqueWords(new String[] {"a", "a", "a"}));
    }

    @Test
    void uniqueAndNotUniqueWords() {

      Assertions.assertEquals(4, counter.countUniqueWords(new String[] {"a", "a", "a", "test",
        "hello", "friend", "test"}));
    }

    @Test
    void nullInputForCountUniqueWords() {

      Assertions.assertThrows(IllegalArgumentException.class, () -> counter.countUniqueWords(null));
    }

    @Test
    void allNullWordsForCountUniqueWords() {

      Assertions.assertEquals(0, counter.countUniqueWords(new String[] {null, null, null}));
    }

    @Test
    void someNullWordsForCountUniqueWords() {

      Assertions.assertEquals(2, counter.countUniqueWords(new String[] {"a", "a", null, "test"}));
    }
  }

  @Test
  void provideNullSetExpectIllegalArgumentException() {

    Assertions.assertThrows(IllegalArgumentException.class, () -> new WordsCounter(null));
  }
}
