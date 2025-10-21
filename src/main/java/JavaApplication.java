import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter text: ");
        String userInput = scan.nextLine();

        int wordCount = getWordCount(userInput);
        System.out.println("Number of words: " + wordCount);
    }

    public static int getWordCount(String userInput) {

        String fileName = "stopWords.txt";
        List<String> stopWords = getStopWords(fileName);

        return (int) Arrays.stream(
                userInput.split("\\s"))
                .filter(token -> token.matches("^[a-zA-Z]*$"))
                .filter(token ->  null != token && !token.isEmpty())
                .filter(token -> !stopWords.contains(token))
        .count();
    }

    private static List<String> getStopWords(String fileName) {
       File file = new File("src/main/resources/stopWords.txt");
        List<String> stopWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line;
            while ((line = reader.readLine()) != null) {
                    stopWords.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stopWords;
    }
}
