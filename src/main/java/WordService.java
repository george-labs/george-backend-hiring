import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordService {
    public List<String> getWordsConsideringStopwords(List<String> userInput, Set<String> stopwords) {
        if(stopwords == null) {
            throw new IllegalArgumentException("Stopwords must not be null!");
        }

        return userInput.stream().filter(n -> !stopwords.contains(n)).toList();
    }
    
    public Set<String> getUniqueWords(List<String> input){
        if(input == null) {
            throw new IllegalArgumentException("Stopwords must not be null!");
        }

        return new HashSet<>(input);
    }
}
