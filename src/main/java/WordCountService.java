import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WordCountService {
    public static int countWordsInString(String userInput) {
        return filterInputString(userInput).size();
    }

    @NotNull
    private static List<String> filterInputString(String userInput) {
        if(userInput == null) {
            throw new IllegalArgumentException("Input String must not be null!");
        }

        String regex = "[a-zA-Z]+";

        String[] splitInput = userInput.split("\\s");

        return Arrays.stream(splitInput)
                .filter(n -> !n.trim().isEmpty())
                .filter(n -> n.matches(regex))
                .toList();
    }

    public static List<String> countWordsInStringWithStopwords(String userInput, Set<String> stopwords) {
        if(stopwords == null) {
            throw new IllegalArgumentException("Stopwords must not be null!");
        }
        
        List<String> filteredInput = filterInputString(userInput);
        return filteredInput.stream().filter(n -> !stopwords.contains(n)).toList();
    }
}
