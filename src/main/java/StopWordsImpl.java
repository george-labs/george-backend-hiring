import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StopWordsImpl implements StopWords {

    private final Set<String> stopWords = new HashSet<>();

    public StopWordsImpl(String fileName) {
        loadStopWords(fileName);
    }

    private void loadStopWords(String fileName) {
        if ((fileName == null) || (fileName.isBlank())) {
            throw new IllegalArgumentException("File name cannot be null or blank");
        }
        try (Scanner scanner = new Scanner(getClass().getClassLoader().getResourceAsStream(fileName))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if ((line != null) && (!line.isBlank())) {
                    stopWords.add(line.toLowerCase());
                }
            }
        }
    }

    @Override
    public boolean isStopWord(String word) {
        if (word == null) {
            return false;
        }
        return stopWords.contains(word.toLowerCase());
    }

    protected Set<String> getAllStopWords() {
        return stopWords;
    }
}
