package com.wulpio;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication {

    private static final String WORD_REGEX = "[a-zA-Z]+(-[a-zA-Z]+)*";
    private static final Pattern PATTERN = Pattern.compile(WORD_REGEX);
    private static final String STOPWORDS_FILE = "stopwords.txt";
    private static final String DELIMITER = " ";

    public WordCounterDto getWordMetrics(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            return new WordCounterDto(0, 0, 0);
        }

        List<String> stopWordsFromFile = FileReader.getResourceFileAsList(STOPWORDS_FILE);
//        System.out.println("stop words:" + stopWordsFromFile);

        List<String> inputAsList = new ArrayList<>(Arrays.asList(inputString.split(DELIMITER)));
        inputAsList.removeAll(stopWordsFromFile);   //remove all stopWords

        Set<String> uniqueWords = new HashSet<>();
        int wordCounter = 0;
        double wordLengthCounter = 0;
        for (String word : inputAsList) {

            boolean regexMatch = doesStringMatchRegex(word);
//            System.out.println("word: " + word + ", match: " + regexMatch);
            if (regexMatch) {
                wordCounter++;
                wordLengthCounter += word.length();
                uniqueWords.add(word);
            }
        }

        return new WordCounterDto(wordCounter, uniqueWords.size(), wordLengthCounter / wordCounter);
    }

    public void readContentAndCountWords(String fileName) {
        String input = FileReader.getResourceFileAsString(fileName);

        if (fileName == null || input == null) {
            input = ConsoleReader.readStringFromConsole();
        }

        WordCounterDto countOfWords = getWordMetrics(input);
        System.out.print(
                "Number of words: " + countOfWords.wordCount()
                        + ", unique: " + countOfWords.uniqueWordCount()
                        + "; average word length: " + countOfWords.averageWordLength()
                        + " characters"
        );
    }

    private boolean doesStringMatchRegex(String s) {
        Matcher matcher = PATTERN.matcher(s);
        return matcher.matches();
    }

}
