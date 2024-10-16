import input.ConsoleInputReader;
import input.FileStopWordsProvider;
import input.InputReader;
import input.StopWordsProvider;
import output.ConsoleOutputWriter;
import output.OutputWriter;
import service.WordCounter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JavaApplication {

    public static void main (String[] args) {
        StopWordsProvider stopWordsProvider = new FileStopWordsProvider();
        Set<String> stopWords = new HashSet<>();
        try {
            stopWords = stopWordsProvider.getStopWords("src/main/resources/stopwords.txt");
        } catch (IOException e){
            System.out.println("Error reading stopwords.txt");
        }
        WordCounter wordCounter = new WordCounter(stopWords);
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();

        outputWriter.write("Enter text:");

        String inputText = inputReader.read();

        String outputString = "Number of words: " + wordCounter.countWords(inputText);
        outputWriter.write(outputString);
    }
}
