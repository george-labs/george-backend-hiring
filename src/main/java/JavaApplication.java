import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        String userInput;
        if(args.length == 0) {
            Scanner scan = new Scanner(System.in);
            System.out.printf("Enter text: ");
            userInput = scan.nextLine();
        }else {
            String inputFileName  = args[0];
            userInput = getUserInputFromFile(inputFileName);
        }
        int wordCount = getWordCount(userInput);
        System.out.println("Number of words: " + wordCount);
    }

    public static String getUserInputFromFile(String inputFileName){
        StringBuilder builder = new StringBuilder();
        File file = new File( inputFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line.trim()+" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  builder.toString();
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
