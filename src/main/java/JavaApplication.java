import input.ConsoleInputReader;
import input.FileWordsProvider;
import input.InputReader;
import input.WordsProvider;
import output.ConsoleOutputWriter;
import output.OutputWriter;
import service.WordCounter;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaApplication {

    public static void main (String[] args) throws IOException {
        OutputWriter outputWriter = new ConsoleOutputWriter();
        WordsProvider stopWordsProvider = new FileWordsProvider();
        Set<String> stopWords = new HashSet<>();
        WordCounter wordCounter = new WordCounter(stopWords);
        String inputText;

        if(args.length > 0 && args[0] != null && !args[0].isEmpty()) {
            //TODO: read not only from resources
            Collection<String> words = stopWordsProvider.getWords(args[0]);
            inputText = words.stream().collect(Collectors.joining());
        } else {
            outputWriter.write("Enter text:");
            InputReader inputReader = new ConsoleInputReader();
            inputText = inputReader.read();
        }

        try {
            stopWords = (Set<String>) stopWordsProvider.getWords("src/main/resources/stopwords.txt");
        } catch (IOException e){
            System.out.println("Error reading stopwords.txt");
        }

        String outputString = "Number of words: " + wordCounter.countWords(inputText);
        outputWriter.write(outputString);
    }
}
