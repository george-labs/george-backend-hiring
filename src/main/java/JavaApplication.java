import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<String> stopWords = new ArrayList<>();

    public static void main(String[] args) {
        readStopWords();
        stopWords.forEach(System.out::println);

        System.out.print("Enter text: ");
        String s1 = SCANNER.nextLine();
        System.out.printf("Number of words: %d%n", countWords(s1));
    }

    protected static long countWords(String inputLine) {
        if (inputLine == null || inputLine.isEmpty()) {
            return 0;
        }

        var splitedString = inputLine.split(Constants.DELIMETER);

        return Arrays.stream(splitedString)
                .filter(substr -> substr.matches(Constants.PATTERN))
//                .filter()
                .count();
    }

    protected static void readStopWords() {
        try (BufferedReader br = new BufferedReader(new FileReader(Constants.STOP_WORDS_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                stopWords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
