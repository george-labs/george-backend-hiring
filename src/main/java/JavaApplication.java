import java.io.IOException;
import java.util.Set;

public class JavaApplication {

    public static void main(String[] args) {

        Set<String> stopWords;

        StopWordReader stopWordReader = new StopWordReader();
        try {
            stopWords = stopWordReader.readStopWordsFromFile("src/main/resources/stopwords.txt");
        } catch (IOException ioException) {
            System.out.println("IOException occured. " + ioException.getMessage());
            return;
        }

        WordCounter wordCounter = new WordCounterImpl(stopWords);

        int numberWords = wordCounter.countWords();

        System.out.println("Number of words: " + numberWords);

    }

}
