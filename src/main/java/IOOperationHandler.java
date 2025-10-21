import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOOperationHandler {
    static String getUserInputFromFile(String inputFileName) {
        StringBuilder builder = new StringBuilder();
        File file = new File(inputFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line.trim() + " ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }

    static List<String> getStopWords(String fileName) {
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

    static String getUserInput(String[] args, InputStream inputStream) {
        String userInput;
        if (args.length == 0) {
            Scanner scan = new Scanner(inputStream);
            System.out.printf("Enter text: ");
            userInput = scan.nextLine();
        } else {
            String inputFileName = args[0];
            userInput = getUserInputFromFile(inputFileName);
        }
        return userInput;
    }
}
