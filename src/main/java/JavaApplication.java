import java.io.*;
import java.util.Set;

public class JavaApplication {

    public static void main(String[] args) {

        Set<String> stopWords;

        InputReader inputReader;

        if (args.length > 0) {
            inputReader = new FileInputReader(args[0]);
        } else {
            inputReader = new ConsoleInputReader();
        }

        String inputString;
        try {
            inputString = inputReader.readInput();
        } catch (IOException ioException) {
            System.out.println("IOException while reading input " + ioException.getMessage());
            return;
        }

        StopWordReader stopWordReader = new StopWordReader();
        try {
            stopWords = stopWordReader.readStopWordsFromFile("src/main/resources/stopwords.txt");
        } catch (IOException ioException) {
            System.out.println("IOException occured. " + ioException.getMessage());
            return;
        }

        WordCounter wordCounter = new WordCounterImpl(stopWords);

        int numberWords = wordCounter.countWords(inputString);

        System.out.println("Number of words: " + numberWords);

    }

}
