import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StopWordList {
    final List<String> stopWords;

    public StopWordList(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public boolean isStopWord(String word) {
        return this.stopWords.contains(word);
    }

    public static StopWordList of(InputStream inputStream) {
        List<String> stopWords = new LinkedList<>();

        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                stopWords.add(scanner.nextLine());
            }
        }

        return new StopWordList(stopWords);
    }
}