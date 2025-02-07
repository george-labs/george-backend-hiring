package com.wulpio;

import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication {

    private static final String WORD_REGEX = "[a-zA-Z]+";
    private static final Pattern PATTERN = Pattern.compile(WORD_REGEX);

    public int getCountOfWords(String inputString) {
        String[] inputAsArray = inputString.split(" ");
//        System.out.println("length: " + inputAsArray.length);

        int wordCounter = 0;
        for (String word : inputAsArray) {
            boolean b = doesStringMatchRegex(word);
//            System.out.println("word: " + word + ", match: " + b);
            if (b) {
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
