package bl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;

public class WordCountApp {

    private final StopWordsProvider stopWordsProvider = new StopWordsFileProvider();
    private final WordCountService wordCountService = new WordCountServiceImpl(stopWordsProvider);

    public void run(String inputFileName) {
        String userInput = inputFileName == null ? readUserInput() : readFileInput(inputFileName);

        long count = wordCountService.countWords(userInput);
        System.out.println("Number of words: " + count);
    }

    private String readFileInput(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (NoSuchFileException e) {
            System.out.println("File \"" + fileName + "\" does not exist.");
            throw new IllegalArgumentException("File \"" + fileName + "\" does not exist.", e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + fileName, e);
        }
    }

    private String readUserInput() {
        System.out.println("Enter text: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
