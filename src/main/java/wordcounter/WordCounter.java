package wordcounter;

import input.InputReadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    public static final String WORD_REGEX = "^[a-zA-Z]+$";
    private final Set<String> stopWords;

    public WordCounter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public int countWords(String input){
        String[] words = input.split(" ");
        List<String> wordList = List.of(words);

        List<String> actualWords = new ArrayList<>();

        wordList.forEach(word -> {
            if (!word.isEmpty()){
                boolean matchesRegex = isMatchesRegex(word);
                boolean isAStopword = stopWords.contains(word);
                if (matchesRegex && !isAStopword){
                    actualWords.add(word);
                }
            }
        });

        return actualWords.size();
    }

    private static boolean isMatchesRegex(String word) {
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }


}
