package view;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static final String STOPWORD_FILE_NAME = "stopwords.txt";
    private final Reader inputStream;
    private final CountService countService;
    private final PrintStream outputStream;

    public App(Reader inputStream, CountService countService, PrintStream outputStream) {
        this.inputStream = inputStream;
        this.countService = countService;
        this.outputStream = outputStream;

    }

    public void application() {
        List<String> stopWords = readStopWordsFromFile();
        outputStream.print("Enter text: ");
        String input = inputStream.readInput();
        int wordCount = countService.getWordsCount(input, stopWords);
        outputStream.println("Number of words: " + wordCount);
    }

    @NotNull
    private List<String> readStopWordsFromFile() {
        InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream(STOPWORD_FILE_NAME);
        Scanner sc = new Scanner(fileInputStream);
        List<String> stopWords = new ArrayList<>();
        while (sc.hasNextLine()) {
            stopWords.add(sc.nextLine());
        }
        return stopWords;
    }


}
