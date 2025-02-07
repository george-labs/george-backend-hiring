package com.wulpio;

import java.io.ByteArrayInputStream;
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

        List<String> resourceFileAsString = FileReader.getResourceFileAsString(STOPWORDS_FILE);
//        System.out.println("stop words:" + resourceFileAsString);

        String[] inputAsArray = inputString.split(" ");
//        System.out.println("length: " + inputAsArray.length);

        int wordCounter = 0;
        for (String word : inputAsArray) {

            boolean isWordFromInputStopWord = resourceFileAsString.contains(word);
            if (isWordFromInputStopWord) {
                System.out.println("word: " + word + " is not counted");
                continue;
            }

            boolean regexMatch = doesStringMatchRegex(word);
//            System.out.println("word: " + word + ", match: " + regexMatch);
            if (regexMatch) {
                wordCounter++;
            }
        }

        return wordCounter;
    }

    public void readLineAndCountWords() {
        String sentenceFromConsole = ConsoleReader.readFromConsole();
        int countOfWords = getCountOfWords(sentenceFromConsole);
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
