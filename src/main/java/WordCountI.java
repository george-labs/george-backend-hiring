import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCountI {

    private Set<String> stopWords;

    WordCountI() {
        stopWords = IOUtility.populateStopWords(this.getClass());
    }

    public WordCountResultDto wordCountI(String inputFileName) {
        String input = IOUtility.getInput(inputFileName);

        //Validate the input
        validateInput(input);

        //Slice the string by space
        WordCountResultDto result = getWordCount(input);

        //Output the length
        System.out.println("Number of words: " + result.getCount() + ", unique: " + result.getUniqueCount());
        return result;
    }

    private WordCountResultDto getWordCount(String input) {
        String[] split = input.split(" ");

        List<String> filteredInput = Arrays.stream(split)
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());
        Set<String> uniqueInput = new HashSet<>(filteredInput);

        return new WordCountResultDto(filteredInput.size(), uniqueInput.size());
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new RuntimeException("The input string is blank!");
        }

        boolean valid = input.matches("[a-zA-Z ]+");
        if (!valid) {
            throw new RuntimeException("The input string contains invalid character(s)!");
        }
    }

}
