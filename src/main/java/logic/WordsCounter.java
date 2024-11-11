package logic;

import java.util.Arrays;
import java.util.List;

public class WordsCounter {

    public static final String WORDS_SEPARATOR_REGEX = "[ \n-.]";
    public static final String ALLOWED_CHARACTERS_REGEX = "[a-zA-Z]+";

    private final List<String> wordList;

    public WordsCounter(String textLine, List<String> stopWords) {
        this.wordList = extractAlphabeticalWordsExcludingStopWords(textLine, stopWords);
    }

    public long getNumberOfUniqueWords() {
        return wordList.stream().distinct().count();
    }

    public int getNumberOfWords() {
        return wordList.size();
    }

    private List<String> extractAlphabeticalWordsExcludingStopWords(String textLine, List<String> stopWords) {
        List<String> wordList = Arrays.asList(textLine.split(WORDS_SEPARATOR_REGEX));
        return wordList.stream()
                .filter(word -> word.matches(ALLOWED_CHARACTERS_REGEX))
                .filter(word -> !stopWords.contains(word))
                .toList();
    }

    public List<String> getWordList() {
        return wordList;
    }
}
