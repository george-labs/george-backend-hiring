package counter;

import java.util.Arrays;

public class WordCounter {

    public int countWords(String text) {
        if (text == null || text.trim().isEmpty()){
            return 0;
        }
       String[] words=  text.split("\\s+");
        return (int) Arrays.stream(words)
                .filter(word -> word.matches("[a-zA-z]+"))
                .count();
    }
}
