package wordcounter;

import java.util.List;

public class WordCounter {

    private final StopWordsReader stopWordsReader;

    public WordCounter(StopWordsReader stopWordsReader) {
        this.stopWordsReader = stopWordsReader;
    }

    public long countWords(String text) {
        List<String> words = splitText(text);
        return words.stream()
                .filter(this::isValidWord)
                .count();
    }

    private List<String> splitText(String text) {
        String[] words = text.split("[\\s.?!,]+");
        return List.of(words);
    }

    private boolean isValidWord(String word) {
        List<String> stopWords = stopWordsReader.getStopWords();
        return word.matches("[a-zA-Z]+") && !stopWords.contains(word);
    }

}
