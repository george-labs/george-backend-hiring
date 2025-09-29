import java.util.List;
import java.util.Set;

public class WordCountService {
    public List<String> countWordsInStringWithStopwords(List<String> userInput, Set<String> stopwords) {
        if(stopwords == null) {
            throw new IllegalArgumentException("Stopwords must not be null!");
        }

        return userInput.stream().filter(n -> !stopwords.contains(n)).toList();
    }
}
