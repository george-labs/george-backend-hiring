import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JavaApplication {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> stopWords = readStopWords(Constants.STOP_WORDS_PATH);

        processUserInput(stopWords);
    }

    private static void processUserInput(List<String> stopWords) {
        System.out.print("Enter text: ");
        String userInput = SCANNER.nextLine();
        System.out.printf("Number of words: %d%n", countWords(userInput, stopWords));
    }

    protected static long countWords(String inputLine, List<String> stopWords) {
        if (inputLine == null || inputLine.isEmpty()) {
            return 0;
        }

        var splitedString = inputLine.split(Constants.DELIMETER);

        return Arrays.stream(splitedString)
                .filter(substr -> substr.matches(Constants.PATTERN))
                .filter(s -> !stopWords.contains(s))
                .count();
    }

    protected static List<String> readStopWords(String path) {
        List<String> stopWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                stopWords.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Warning: The system cannot find the file containing stop words");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopWords;
    }
}
