import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static file.Warnings.*;
import static java.lang.String.format;

public class JavaApplication {

    private static final String NUMBER_OF_WORDS = "Number of words: %d%n";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> stopWords = readStopWords(Constants.STOP_WORDS_PATH);

        if (args.length > 1) {
            System.out.println(UNEXPECTED_PROGRAM_ARGUMENTS);
        }

        if (args.length > 0) {
            processFileUserInput(stopWords, args[0]);
            return;
        }

        processConsoleUserInput(stopWords);
    }

    private static void processConsoleUserInput(List<String> stopWords) {
        System.out.print("Enter text: ");
        String userInput = SCANNER.nextLine();

        long wordsCount = 0L;
        if (userInput != null && !userInput.isEmpty()) {
            wordsCount = countWords(List.of(userInput.split(Constants.DELIMETER)), stopWords);
        }
        System.out.printf(NUMBER_OF_WORDS, wordsCount);
    }

    private static void processFileUserInput(List<String> stopWords, String path) {
        List<String> userInput = readFileUserInput(format(Constants.DEFAULT_PATH, path));
        System.out.printf(NUMBER_OF_WORDS, countWords(userInput, stopWords));
    }


    protected static long countWords(List<String> words, List<String> stopWords) {
        return words.stream()
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
            System.out.println(STOP_WORDS_FILE_NOT_FOUND.getErrorMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stopWords;
    }

    protected static List<String> readFileUserInput(String path) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {

                words.addAll(List.of(line.split(Constants.DELIMETER)));
            }
        } catch (FileNotFoundException e) {
            System.out.println(USER_INPUT_FILE_NOT_FOUND.getErrorMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
