import sentence.Sentence;
import sentence.Word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class JavaApplication {
    private static final int TEXT_INVALID_EXIT = 5;


    public static void main(String[] args) {
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

        System.out.println("Number of words: " + sentence.getWords().size());
    }
}
