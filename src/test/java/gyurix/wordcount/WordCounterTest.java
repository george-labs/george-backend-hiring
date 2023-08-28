package gyurix.wordcount;

import gyurix.wordcount.dto.WordCounterOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {
  private static final WordCounter wordCounter = new WordCounter();
  private static final DecimalFormat decimalFormat = new DecimalFormat("##0.##");

  @ParameterizedTest
  @CsvSource({"1,1,4,word",
          "2,1,4,word word",
          "2,1,4,        word         word          ",
          "1,1,4, wo3rd wo@@rd word",
          "0,0,0,word?",
          "3,2,4.33,word- word. word! word? word",
          "7,4,4.71,line 1\tline second\t third line \r fourth line",
          "7,6,6.43,Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."})
  public void testBasicWordCount(int expectedWords, int expectedUniqueWords, String expectedAverageLength, String inputString) {
    WordCounterOutput wordCounterOutput = wordCounter.countWords(inputString);
    assertEquals(expectedWords, wordCounterOutput.getWords());
    assertEquals(expectedUniqueWords, wordCounterOutput.getUniqueWords());
    assertEquals(expectedAverageLength, decimalFormat.format(wordCounterOutput.getAverageWordLength()));
  }

  @ParameterizedTest
  @CsvSource({"4,Mary had the little lamb",
          "5,Mary had a little lamb yes",
          "6,Mary had on little lamb on   on might be",
          "7,Mary had off little off lamb yet again so"})
  public void testStopWords(int expectedCount, String inputString) {
    assertEquals(expectedCount, wordCounter.countWords(inputString).getWords());
  }
}
