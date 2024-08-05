package wordcounter;

import java.util.List;
import java.util.Set;

public class WordCounter {

    private final StopWordsReader stopWordsReader;

    public WordCounter(StopWordsReader stopWordsReader) {
        this.stopWordsReader = stopWordsReader;
    }

    public long countWords(String text) {
        List<String> words = splitTextForWords(text);
        return words.stream()
                .filter(this::isValidWord)
                .count();
    }

    private List<String> splitTextForWords(String text) {
        String[] words = text.split("[\\s.?!,]+");
        return List.of(words);
    }

    private boolean isValidWord(String word) {
        Set<String> stopWords = stopWordsReader.getStopWords();
        return word.matches("[a-zA-Z]+") && !stopWords.contains(word);
    }

}
