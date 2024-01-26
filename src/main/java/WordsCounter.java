import java.util.HashSet;
import java.util.List;

public class WordsCounter {

    public int countWordsExceptStopWords(List<String> words) {
        return words.size();
    }

    public int getUniqueCountExceptStopWords(List<String> words) {
        return new HashSet<>(words).size();
    }
}
