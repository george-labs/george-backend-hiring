package unit.rule.ignore;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rule.ignore.WordsToIgnoreRule;

class WordsToIgnoreRuleTest {
  private WordsToIgnoreRule wordsToIgnoreRule;

  @AfterEach
  void afterEach() {
    this.wordsToIgnoreRule = null;
  }

  @Test
  void testWordToIgnoreValidated() {
    final List<String> testWordsToIgnore = List.of("oleg", "interview");
    this.wordsToIgnoreRule = new WordsToIgnoreRule(testWordsToIgnore);
    final String wordToIgnore = "oleg";
    Assertions.assertFalse(this.wordsToIgnoreRule.validate(wordToIgnore));
  }

  @Test
  void testWordNotToIgnoreValidated() {
    final List<String> testWordsToIgnore = List.of("oleg", "interview");
    this.wordsToIgnoreRule = new WordsToIgnoreRule(testWordsToIgnore);
    final String wordNotToIgnore = "olegfomchenko";
    Assertions.assertTrue(this.wordsToIgnoreRule.validate(wordNotToIgnore));
  }

  @Test
  void testEmptyWordsToValidate() {
    final List<String> testWordsToIgnore = List.of();
    this.wordsToIgnoreRule = new WordsToIgnoreRule(testWordsToIgnore);
    final String wordNotToIgnore = "olegfomchenko";
    Assertions.assertTrue(this.wordsToIgnoreRule.validate(wordNotToIgnore));
  }

  @Test
  void testNullWordsToValidate() {
    final List<String> testWordsToIgnore = null;
    Assertions.assertThrows(NullPointerException.class, () -> new WordsToIgnoreRule(testWordsToIgnore));
  }

  @Test
  void testWordsToValidateWithNull() {
    final List<String> testWordsToIgnore = new ArrayList<>();
    testWordsToIgnore.add("oleg");
    testWordsToIgnore.add(null);
    this.wordsToIgnoreRule = new WordsToIgnoreRule(testWordsToIgnore);
    final String wordNotToIgnore = "olegfomchenko";
    Assertions.assertTrue(this.wordsToIgnoreRule.validate(wordNotToIgnore));
  }
}