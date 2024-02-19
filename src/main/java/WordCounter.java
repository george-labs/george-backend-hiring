import java.util.*;

public class WordCounter {

    private static final Set<Character> SUPPORTED_PUNCTIONAL_MARKS = Set.of('-', '.');

    private final StopWords stopWords;

    public WordCounter(StopWords stopWords) {
        if (stopWords == null) {
            throw new IllegalArgumentException("Stop words cannot be null");
        }
        this.stopWords = stopWords;
    }

    public WordCountResult count(String text) {
        if ((text == null) || text.isBlank()) {
            throw new IllegalArgumentException("Unsupported input text");
        }
        String[] words = text.split("\\s+");
        return countWords(words);
    }

    protected WordCountResult countWords(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException("Unsupported array of words");
        }
        List<String> validWords = filterInvalidWords(words);
        int count = validWords.size();
        int unique = new HashSet<String>(validWords).size();
        return new WordCountResult(count, unique);
    }

    private List<String> filterInvalidWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isValidWord(words[i])) {
                result.add(words[i]);
            }
        }
        return result;
    }

    protected boolean isValidWord(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        if (word.length() == 1 || SUPPORTED_PUNCTIONAL_MARKS.contains(word.charAt(0))) {
            return false;
        }
        String processedWord = processPunctionalMarks(word.toLowerCase());
        if (stopWords.isStopWord(processedWord)) {
            return false;
        }
        for (int i = 0; i < processedWord.length(); i++) {
            char character = processedWord.charAt(i);
            if ((character < 'a') || (character > 'z')) {
                return false;
            }
        }
        return true;
    }

    private String processPunctionalMarks(String word) {
        String processed = word.replace("-", "").replace(".", "");
        return processed;
    }
}
