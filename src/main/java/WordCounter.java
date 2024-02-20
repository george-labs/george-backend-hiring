import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class WordCounter {

    private final Set<String> stopWords;

    public WordCounter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public Counter countWords(String someText) {
        if (someText == null) {
            throw new IllegalStateException("Text cannot be empty.");
        }

        Set<String> usedWords = new HashSet<>();
        Counter counter = new Counter();
        String[] words = someText.split("[\\s\\.,]");
        for (String word : words) {
            if (!stopWords.contains(word) && word.matches("[a-zA-Z-]+")) {
                usedWords.add(word);
                counter.setCount(counter.getCount()+1);
                counter.setTotalCharacters(counter.getTotalCharacters()+word.length());
            }
        }
        BigDecimal averageLength = BigDecimal.valueOf(counter.getTotalCharacters()).divide(BigDecimal.valueOf(counter.getCount()), 2, RoundingMode.CEILING);
        counter.setUsedWords(usedWords);
        counter.setAverageLength(averageLength);
        counter.setCountUnique(counter.getUsedWords().size());
        return counter;
    }
}
