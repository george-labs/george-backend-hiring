import java.io.*;
import java.util.Set;

public class JavaApplication {

    public static void main(String[] args) {

        Set<String> stopWords;

        InputStream inputStream;

        if (args.length > 0) {
            String filePathString = args[0];
            File file = new File(filePathString);
            try {
                inputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (IOException ioException) {
                System.out.println("IOException occured. " + ioException.getMessage());
                return;
            }
        } else {
            inputStream = System.in;
        }

        StopWordReader stopWordReader = new StopWordReader();
        try {
            stopWords = stopWordReader.readStopWordsFromFile("src/main/resources/stopwords.txt");
        } catch (IOException ioException) {
            System.out.println("IOException occured. " + ioException.getMessage());
            return;
        }

        WordCounter wordCounter = new WordCounterImpl(stopWords, inputStream);

        int numberWords = wordCounter.countWords();

        System.out.println("Number of words: " + numberWords);

    }

}
