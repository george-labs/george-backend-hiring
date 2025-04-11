package service.counter;


import service.reader.FileReader;
import service.reader.Reader;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter implements Counter {

    @Override
    public long countWords(String text) {

        Reader fileReader = new FileReader();
        String stopWords = fileReader.readInput();

        // Check input
        if (text == null || text.isBlank()) {
            return 0;
        }

        // Create desired pattern to match each word
        Pattern pattern = Pattern.compile("[a-zA-Z]+");

        // Split array by each word
        List<String> textList = Arrays.asList(text.split(" "));

        // Create array of blacklisted words
        List<String> blackListedWords = Arrays.asList(stopWords.split(" "));

        // Return count for applied pattern
        return textList.stream()
                .filter(word -> pattern.matcher(word).matches() && !blackListedWords.contains(word))
                .count();
    }
}
