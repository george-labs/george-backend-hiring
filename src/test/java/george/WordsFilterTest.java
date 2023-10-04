package george;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordsFilterTest {

  @Test
  void filterWhen1WordInInputAndTheSameWordInFilterThenZero() {
    String word1 = "word1";
    WordsFilter wordsFilter = new WordsFilter(Set.of(word1));

    List<String> strings = wordsFilter.filter(List.of(word1));

    Assertions.assertEquals(0, strings.size());
  }

  @Test
  void filterWhen2WordsInInputAnd1SameWordInFilterThen1Word() {
    String word1 = "word1";
    WordsFilter wordsFilter = new WordsFilter(Set.of(word1));

    List<String> strings = wordsFilter.filter(List.of(word1, "word2"));

    Assertions.assertEquals(1, strings.size());
  }

  @Test
  void filterWhen2WordsInInputAndAnotherWordInFilterThen2Word2() {
    String word1 = "word1";
    WordsFilter wordsFilter = new WordsFilter(Set.of(word1));

    List<String> strings = wordsFilter.filter(List.of("word3", "word2"));

    Assertions.assertEquals(2, strings.size());
  }

  @Test
  void filterWhen2WordsInInputAndTheSameTwoWordsInFilterThenZero() {
    String word1 = "word1";
    String word2 = "word2";
    WordsFilter wordsFilter = new WordsFilter(Set.of(word1, word2));

    List<String> strings = wordsFilter.filter(List.of(word1, word2));

    Assertions.assertEquals(0, strings.size());
  }
}