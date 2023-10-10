package wordcounter;

public interface WordCounter {
    long countWords(String line);
    long countUniqueWords(String line);
    double getAverage(String line);
}
