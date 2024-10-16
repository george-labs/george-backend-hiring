import input.ConsoleInputReader;
import input.FileWordsProvider;
import input.InputReader;
import input.WordsProvider;
import output.ConsoleOutputWriter;
import output.OutputWriter;
import service.InputReaderService;
import service.WordCounter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JavaApplication {

    public static void main(String[] args) throws IOException {

        Set<String> stopWords = new HashSet<>();
        String inputText;
        OutputWriter outputWriter = new ConsoleOutputWriter();
        InputReader inputReader = new ConsoleInputReader();
        WordsProvider fileWordsProvider = new FileWordsProvider();
        InputReaderService inputReaderService = new InputReaderService(fileWordsProvider, outputWriter, inputReader);

        inputText = inputReaderService.getInput(args);

        try {
            stopWords = new HashSet<>(fileWordsProvider.getWords("src/main/resources/stopwords.txt"));
        } catch (IOException e) {
            System.out.println("Error reading stopwords.txt");
        }

        WordCounter wordCounter = new WordCounter(stopWords);

        String outputString = "Number of words: " + wordCounter.countWords(inputText);
        outputWriter.write(outputString);
    }

}
