package service.counter;


import service.reader.FileReader;
import service.reader.Reader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter implements Counter {

    private static final String PATTERN = "[a-zA-Z]+";

    @Override
    public long countWords(String text) {

        if (checkInputText(text)) {
            return 0;
        }

        // Create desired pattern to match each word
        Pattern pattern = Pattern.compile(PATTERN);

        // Split array by each word
        List<String> textList = Arrays.asList(text.split(" "));

        // Return count for applied pattern
        return textList.stream()
                .filter(word -> pattern.matcher(word).matches())
                .count();
    }

    @Override
    public long countWordsWithStopWords(String text) {

        if (checkInputText(text)) {
            return 0;
        }

        // Read blacklisted words from stopwords file
        Reader fileReader = new FileReader();
        String stopWords = fileReader.readInput();

        // Create array of blacklisted words
        List<String> blackListedWords = Arrays.asList(stopWords.split(" "));

        // Create desired pattern to match each word
        Pattern pattern = Pattern.compile(PATTERN);

        // Split array by each word
        List<String> textList = Arrays.asList(text.split(" "));

        // Return count for applied pattern
        return textList.stream()
                .filter(word -> pattern.matcher(word).matches() && !blackListedWords.contains(word))
                .count();
    }

    private boolean checkInputText(String text) {
        // Check input
        return text == null || text.isBlank();
    }
}
