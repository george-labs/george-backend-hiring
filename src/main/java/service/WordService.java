package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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

    public int countUniqueWords(List<String> inputWords, List<String> wordsNotToCount) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Set<String> uniqueWordSet = new HashSet<>();
        for (String word : inputWords) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches() && !wordsNotToCount.contains(word)) {
                uniqueWordSet.add(word);
            }
        }
        return uniqueWordSet.size();
    }
}
