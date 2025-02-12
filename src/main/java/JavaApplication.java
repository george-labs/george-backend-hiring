import utils.RegexPatterns;
import utils.StringSplitter;
import utils.StringValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaApplication {

    public static void main(String[] args) {

        System.out.print("Enter the text: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String sentence = reader.readLine();
            var words = StringSplitter.splitBy(sentence, " ");
            var numberOfMatches = words.stream()
                    .filter(word -> StringValidator.matchPattern(word, RegexPatterns.ALPHABET_PATTERN)).count();
            System.out.print("Number of words: " + numberOfMatches);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
