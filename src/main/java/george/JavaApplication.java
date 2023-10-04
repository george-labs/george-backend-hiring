package george;

import george.filter.StopWordsFilter;
import george.filter.UniquenessWordsFilter;
import george.reader.TextReaderFactory;
import java.util.HashSet;
import java.util.List;

public class JavaApplication {

  public static void main(String[] args) {

    WordsFileReader wordsFileReader = new WordsFileReader("stopwords.txt");
    List<String> filterWords = wordsFileReader.read();

    TextReader reader = TextReaderFactory.createReader(args.length == 1 ? args[0] : null);

    WordsSplitter splitter = new WordsSplitter();
    StopWordsFilter stopWordsFilter = new StopWordsFilter(new HashSet<>(filterWords));
    UniquenessWordsFilter uniquenessWordsFilter = new UniquenessWordsFilter();

    String text = reader.read();
    List<String> allWords = splitter.split(text);
    List<String> filteredWords = stopWordsFilter.filter(allWords);
    List<String> uniqWords = uniquenessWordsFilter.filter(filteredWords);

    System.out.println("Number of words: " + filteredWords.size());
    System.out.println("Uniq of words: " + uniqWords.size());
  }
}
