package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordService {

    public static int countWords(String inputString) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        String[] inputWords = inputString.split(" ");
        int wordsWithoutSpecialCharactersCounter = 0;
        for (String word : inputWords) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                wordsWithoutSpecialCharactersCounter++;
            }
        }
        return wordsWithoutSpecialCharactersCounter;
    }
}
