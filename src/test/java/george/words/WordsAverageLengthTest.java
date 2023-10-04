package george.words;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordsAverageLengthTest {

  private WordsAverageLength wordsAverageLength = new WordsAverageLength();

  @Test
  void calculateOnEmptyList() {
    double avarage = wordsAverageLength.calculate(List.of());

    Assertions.assertEquals(0.0, avarage);
  }

  @Test
  void calculateOnSingleWord() {
    double avarage = wordsAverageLength.calculate(List.of("12345"));

    Assertions.assertEquals(5.0, avarage);
  }

  @Test
  void calculateOnDoubleWord() {
    double avarage = wordsAverageLength.calculate(List.of("12345", "12345"));

    Assertions.assertEquals(5.0, avarage);
  }

}