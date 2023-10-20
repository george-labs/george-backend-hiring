import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCounter {

    private static Pattern validWords = Pattern.compile("[a-zA-Z]+");


    public long countWords(String words){
        return Arrays.stream(words.split("\\s+"))
                .filter(this::isWordValid)
                .count();
    }

    private boolean isWordValid(String word){
        return validWords.matcher(word).matches();
    }

}


