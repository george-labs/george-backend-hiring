package george;

import george.reader.TextReaderFactory;
import java.util.HashSet;
import java.util.List;

public class JavaApplication {

  public static void main(String[] args) {

    WordsFileReader wordsFileReader = new WordsFileReader("stopwords.txt");
    List<String> filterWords = wordsFileReader.read();

    TextReader reader = TextReaderFactory.createReader(args.length == 1 ? args[0] : null);
    WordsSplitter splitter = new WordsSplitter();
    WordsFilter wordsFilter = new WordsFilter(new HashSet<>(filterWords));

    String text = reader.read();
    List<String> strings = splitter.split(text);
    strings = wordsFilter.filter(strings);

    System.out.println("Number of words: " + strings.size());
  }
}
