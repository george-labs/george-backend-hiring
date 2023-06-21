package service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordService {

    public int countWords(List<String> inputWords, List<String> wordsNotToCount) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        int wordsWithoutSpecialCharactersCounter = 0;
        for (String word : inputWords) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches() && !wordsNotToCount.contains(word)) {
                wordsWithoutSpecialCharactersCounter++;
            }
        }
        return wordsWithoutSpecialCharactersCounter;
    }
}
