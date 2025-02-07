import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static file.Warnings.STOP_WORDS_FILE_NOT_FOUND;
import static file.Warnings.UNEXPECTED_PROGRAM_ARGUMENTS;
import static java.lang.String.format;

public class JavaApplication {

    private static final String OUTPUT_WITH_UNIQUE_COUNTER = "Number of words: %d, unique: %d";
    private static final String OUTPUT = "Number of words: %d%n, unique: %d%n";
    private static final String GREETINGS = "Enter text: ";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> stopWords = readFile(Constants.STOP_WORDS_PATH, false).keySet().stream().toList();

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
        System.out.printf(OUTPUT, wordsCount);
    }

    private static void processFileUserInput(List<String> stopWords, String path) {
        HashMap<String, Integer> userInput = readFile(format(Constants.DEFAULT_PATH, path), true);

        System.out.println(format(OUTPUT_WITH_UNIQUE_COUNTER, countWords(userInput.keySet().stream().toList(), stopWords), countUniqueWords(userInput, stopWords)));
    }

    private static long countUniqueWords(HashMap<String, Integer> map, List<String> stopWords) {
        return map.entrySet().stream()
                .filter(entry -> !stopWords.contains(entry.getKey()))
                .filter(entry -> entry.getValue() == 1).count();
    }


    protected static long countWords(List<String> words, List<String> stopWords) {
        return words.stream()
                .filter(substr -> substr.matches(Constants.PATTERN))
                .filter(s -> !stopWords.contains(s))
                .count();
    }

    protected static HashMap<String, Integer> readFile(String path, boolean isFileInput) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isFileInput) {
                    Stream.of(line.split(Constants.DELIMETER))
                            .forEach(l -> resultMap.put(l, resultMap.get(l) == null ? 1 : resultMap.get(l) + 1));
                } else {
                    resultMap.put(line, 0);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(STOP_WORDS_FILE_NOT_FOUND.getErrorMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
