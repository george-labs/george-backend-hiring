package service.counter;


import service.reader.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private static final String PATTERN = "[a-zA-Z]+";
    private static final String STOPWORDS_FILE_NAME = "stopwords.txt";

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


    public long countWordsWithStopWords(String text) {

        if (checkInputText(text)) {
            return 0;
        }

        // Read blacklisted words from stopwords file
        FileReader fileReader = new FileReader();
        String stopWords = fileReader.readInput(STOPWORDS_FILE_NAME);

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
