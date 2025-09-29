import java.util.Arrays;
import java.util.List;

public class WordCountService {
    public static int countWordsInString(String userInput) {
        if(userInput == null) {
            throw new IllegalArgumentException("Input String must not be null!");
        }

        String regex = "[a-zA-Z]+";
        int numberOfWords = 0;

        if(!userInput.trim().isEmpty()){
            String[] splitInput = userInput.split("\\s");

            List<String> filteredInput = Arrays.stream(splitInput)
                    .filter(n -> n.matches(regex))
                    .toList();

            numberOfWords = filteredInput.size();
        }
        return numberOfWords;
    }
}
