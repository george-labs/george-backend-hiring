import java.util.Arrays;

public class WordCounter {

    public String countWords(String words){
        long count = Arrays.stream(words.split("\\s+")).count();
        return "Number of words: " + count;
    }
}


