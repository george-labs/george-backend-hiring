import sentence.Sentence;
import sentence.WordCounter;

import java.io.*;
import static java.lang.System.exit;


public class JavaApplication {
    private static final int TEXT_INVALID_EXIT = 5;


    public static void main(String[] args) {
        File ignoreFile = new File("./stopwords.txt");
        WordCounter wordCounter = new WordCounter(ignoreFile);

        System.out.print("Enter text: ");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        var input = "";
        try{
            input = reader.readLine();
        }
        catch (IOException x) {
            System.err.println("Could not read input. Something happened");
            exit(TEXT_INVALID_EXIT);
        }
        var sentence = new Sentence(input);

        System.out.println("Number of words: " + wordCounter.countWords(sentence));
    }
}
