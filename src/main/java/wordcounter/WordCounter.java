package wordcounter;

import java.util.List;

public interface WordCounter {
    long countWords(String line);
    long countUniqueWords(String line);
    double getAverage(String line);
    List<String> getUniqueWords(String line);
}
