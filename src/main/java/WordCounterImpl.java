import java.util.*;

public class WordCounterImpl implements WordCounter {

    Set<String> stopWords;

    WordCounterImpl() {
        stopWords = Collections.emptySet();
    }

    WordCounterImpl(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public int countWords(String s) {

        int count = 0;


        String[] tokens = s.trim().split("\\s+");

        for(String token : tokens) {
            if(containsOnlyAlphabetic(token) && !stopWords.contains(token) && !token.isBlank()) {
                count++;
            }
        }

        return count;
    }

    private boolean containsOnlyAlphabetic(String token) {
        for(char c : token.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }
}
