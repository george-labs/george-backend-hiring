import io.FileReader;
import io.IOHandler;

import java.io.IOException;

public class JavaApplication {



    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler(System.in);
        FileReader fileReader = new FileReader();

        try {
            final var stopWords = fileReader.getStopWords();
            WordCounter wordCounter = new WordCounter(stopWords);
            final var input = ioHandler.getCmdInput();
            final var wordCount = wordCounter.getNumberOfWords(input);

            System.out.println("Number of words: " + wordCount);
        } catch (IOException e) {
            System.out.println("###Exception happened: " + e.getMessage());
        }
    }

}
