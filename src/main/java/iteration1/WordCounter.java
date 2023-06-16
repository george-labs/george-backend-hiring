package iteration1;

import java.util.Arrays;
import java.util.List;

public class WordCounter {

    public int count(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));

        return words.size() + 1;
    }

}
