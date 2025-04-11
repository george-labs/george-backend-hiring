package util.counter;


import util.reader.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private static final String PATTERN = "[a-zA-Z\\-]+";
    private static final String STOPWORDS_FILE_NAME = "stopwords.txt";

    public long countWords(String text) {

        if (checkInputText(text)) {
            return 0;
        }

        // Return count for applied pattern
        return getFilteredWords(text).size();
    }

    public long countUniqueWords(String text) {

        if (checkInputText(text)) {
            return 0;
        }

        // Get count of distinct items from filtered words array
        List<String> textList = getFilteredWords(text);
        return textList.stream().distinct().count();
    }

    public double calculateAverageWordLength(String text) {

        if (checkInputText(text)) {
            return 0;
        }

        List<String> wordList = getFilteredWords(text);
        int totalWordLength = 0;
        for (String word : wordList) {
            totalWordLength += word.length();
        }

        return (double) totalWordLength / wordList.size();
    }

    public List<String> getFilteredWords(String text) {

        // Replace '.' with ' ' to split by
        String modifiedText = text.replaceAll("[.]", " ");

        // Split array by each word
        List<String> textList = Arrays.asList(modifiedText.split(" "));

        // Read blacklisted words from stopwords file
        FileReader fileReader = new FileReader();
        String stopWords = fileReader.readInput(STOPWORDS_FILE_NAME);

        // Create array of blacklisted words
        List<String> blackListedWords = Arrays.asList(stopWords.split(" "));

        // Create desired pattern to match each word
        Pattern wordPattern = Pattern.compile(PATTERN);

        return textList.stream()
                .filter(word -> wordPattern.matcher(word).matches() && !blackListedWords.contains(word) && !word.isBlank()).toList();
    }

    private boolean checkInputText(String text) {
        // Check input
        return text == null || text.isBlank();
    }
}
