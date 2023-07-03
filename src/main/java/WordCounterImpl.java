import java.io.InputStream;
import java.util.*;

public class WordCounterImpl implements WordCounter {

    Set<String> stopWords;
    InputStream inputStream;

    WordCounterImpl() {
        stopWords = Collections.emptySet();
        inputStream = System.in;
    }

    WordCounterImpl(Set<String> stopWords) {
        this.stopWords = stopWords;
        inputStream = System.in;
    }

    WordCounterImpl(InputStream inputStream) {
        this.stopWords = Collections.emptySet();
        this.inputStream = inputStream;
    }

    WordCounterImpl(Set<String> stopWords, InputStream inputStream) {
        this.stopWords = stopWords;
        this.inputStream = inputStream;
    }

    @Override
    public int countWords() {
        Scanner scanner = new Scanner(inputStream);

        int count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.trim().split("\\s+");

            for(String token : tokens) {
                if(containsOnlyAlphabetic(token) && !stopWords.contains(token)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean containsOnlyAlphabetic(String token) {
        for(char c : token.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }
}
