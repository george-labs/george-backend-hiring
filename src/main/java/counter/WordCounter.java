package counter;

import java.util.Arrays;

public class WordCounter {

    public int countWords(String text) {
        if (text == null || text.trim().isEmpty()){
            return 0;
        }
       String[] words=  text.split("[^\\p{Alpha}]+");
        return (int) Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .count();
    }
}
