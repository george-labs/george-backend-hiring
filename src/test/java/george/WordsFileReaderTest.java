package george;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordsFileReaderTest {

  @Test
  void readWordsWithoutBlankLines() {
    WordsFileReader wordsFileReader = new WordsFileReader(
        "src/test/resources/george/stopwords.txt");

    List<String> strings = wordsFileReader.read();

    Assertions.assertEquals(2, strings.size());
    Assertions.assertEquals("word1", strings.get(0));
    Assertions.assertEquals("word2", strings.get(1));
  }

  @Test
  void readWordsWithBlankLines() {
    WordsFileReader wordsFileReader = new WordsFileReader(
        "src/test/resources/george/stopwordsWithBlankLines.txt");

    List<String> strings = wordsFileReader.read();

    Assertions.assertEquals(2, strings.size());
    Assertions.assertEquals("word1", strings.get(0));
    Assertions.assertEquals("word2", strings.get(1));
  }
}