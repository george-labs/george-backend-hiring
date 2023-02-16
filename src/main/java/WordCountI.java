import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class WordCountI {

    private Set<String> stopWords;

    WordCountI() {
        populateStopWords();
    }

    public WordCountResultDto wordCountI(String inputFileName) {
        String input = getInput(inputFileName);

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

    private String getInput(String inputFileName) {
        if (inputFileName != null) {
            return getInputFromFile(inputFileName);
        }

        //Get a sentence from the user
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter text: ");

        return myObj.nextLine();
    }

    private String getInputFromFile(String inputFileName) {
        //TODO refactor later
        URL resource = this.getClass().getClassLoader().getResource(inputFileName);
        if (resource != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
                return br.lines().collect(Collectors.joining(" "));
            } catch (IOException ex) {
                //TODO think about testing this branch
                System.out.println("Cannot read the" + inputFileName + " file!");
                throw new RuntimeException(ex);
            }
        } else {
            throw new RuntimeException(new FileNotFoundException("The specified file could not be found!"));
        }
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

    private void populateStopWords() {
        URL resource = this.getClass().getClassLoader().getResource("stopwords.txt");
        //TODO think about it
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            stopWords = br.lines().collect(Collectors.toSet());
        } catch (IOException ex) {
            System.out.println("Cannot read the stopwords.txt file!");
        }
    }

}
