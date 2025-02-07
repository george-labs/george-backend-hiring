import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static file.Warnings.STOP_WORDS_FILE_NOT_FOUND;
import static file.Warnings.UNEXPECTED_PROGRAM_ARGUMENTS;
import static java.lang.String.format;

public class JavaApplication {

    private static final String NUMBER_OF_WORDS = "Number of words: %d%n";
    private static final String GREETINGS = "Enter text: ";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> stopWords = readFile(Constants.STOP_WORDS_PATH, false);

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
        System.out.print(GREETINGS);
        String userInput = SCANNER.nextLine();

        long wordsCount = 0L;
        if (userInput != null && !userInput.isEmpty()) {
            wordsCount = countWords(List.of(userInput.split(Constants.DELIMETER)), stopWords);
        }
        System.out.printf(NUMBER_OF_WORDS, wordsCount);
    }

    private static void processFileUserInput(List<String> stopWords, String path) {
        List<String> userInput = readFile(format(Constants.DEFAULT_PATH, path), true);
        System.out.printf(NUMBER_OF_WORDS, countWords(userInput, stopWords));
    }


    protected static long countWords(List<String> words, List<String> stopWords) {
        return words.stream()
                .filter(substr -> substr.matches(Constants.PATTERN))
                .filter(s -> !stopWords.contains(s))
                .count();
    }

    protected static List<String> readFile(String path, boolean isFileInput) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isFileInput) {
                    result.addAll(List.of(line.split(Constants.DELIMETER)));
                } else {
                    result.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(STOP_WORDS_FILE_NOT_FOUND.getErrorMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
