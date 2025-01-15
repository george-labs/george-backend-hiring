package unit.separator;

import exception.NullInputException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import separator.DelimiterSeparator;

class DelimiterSeparatorTest {

  private DelimiterSeparator delimiterSeparator;

  @BeforeEach
  void beforeEach() {
    this.delimiterSeparator = new DelimiterSeparator();
  }

  @Test
  void testNullString() {
    final String nullString = null;
    Assertions.assertThrows(NullInputException.class, () -> this.delimiterSeparator.separate(nullString));
  }

  @Test
  void testEmptyString() {
    final String emptyString = "";
    final List<String> actualSeparatedWords = this.delimiterSeparator.separate(emptyString);
    final List<String> expectedSeparatedWords = List.of(emptyString);
    Assertions.assertIterableEquals(expectedSeparatedWords, actualSeparatedWords);
  }

  @Test
  void testWordsSeparatedByOnlySpaces() {
    final String inputString = "Oleg is on a interview";
    final List<String> actualSeparatedWords = this.delimiterSeparator.separate(inputString);
    final List<String> expectedSeparatedWords = List.of("Oleg", "is", "on", "a", "interview");
    Assertions.assertIterableEquals(expectedSeparatedWords, actualSeparatedWords);
  }

  @Test
  void testWordsSeparatedBySpacesAndOtherDelimiters() {
    final String inputString = "Oleg, is on. A interview";
    final List<String> actualSeparatedWords = this.delimiterSeparator.separate(inputString);
    final List<String> expectedSeparatedWords = List.of("Oleg,", "is", "on.", "A", "interview");
    Assertions.assertIterableEquals(expectedSeparatedWords, actualSeparatedWords);
  }

  @Test
  void testWordsAndOtherCharactersSeparatedBySpaces() {
    final String inputString = "Oleg , is on . A interview";
    final List<String> actualSeparatedWords = this.delimiterSeparator.separate(inputString);
    final List<String> expectedSeparatedWords = List.of("Oleg", ",", "is", "on", ".", "A", "interview");
    Assertions.assertIterableEquals(expectedSeparatedWords, actualSeparatedWords);
  }
}