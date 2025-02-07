package com.wulpio;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication {

    private static final String WORD_REGEX = "[a-zA-Z]+";
    private static final Pattern PATTERN = Pattern.compile(WORD_REGEX);
    private static final String STOPWORDS_FILE = "stopwords.txt";

    public int getCountOfWords(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            return 0;
        }

        List<String> stopWordsFromFile = FileReader.getResourceFileAsList(STOPWORDS_FILE);
//        System.out.println("stop words:" + stopWordsFromFile);

        List<String> inputAsList = new ArrayList<>(Arrays.asList(inputString.split(" ")));
        inputAsList.removeAll(stopWordsFromFile);   //remove all stopWords

        int wordCounter = 0;
        for (String word : inputAsList) {

            boolean regexMatch = doesStringMatchRegex(word);
//            System.out.println("word: " + word + ", match: " + regexMatch);
            if (regexMatch) {
                wordCounter++;
            }
        }

        return wordCounter;
    }

    public void readContentAndCountWords(String fileName) {
        String input = FileReader.getResourceFileAsString(fileName);

        if (fileName == null || input == null) {
            input = ConsoleReader.readFromConsole();
        }

        int countOfWords = getCountOfWords(input);
        System.out.println("Number of words: " + countOfWords);
    }

    private boolean doesStringMatchRegex(String s) {
        Matcher matcher = PATTERN.matcher(s);
        return matcher.matches();
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

}
