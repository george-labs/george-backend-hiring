import java.util.*;

public class WordCounter {

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
        text = processPunctionalMarks(text);
        String[] words = text.split("\\s+");
        return countWords(words);
    }

    private String processPunctionalMarks(String word) {
        String processed = word.replace("-", "").replace(".", " ");
        processed = processed.trim();
        return processed;
    }

    protected WordCountResult countWords(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException("Unsupported array of words");
        }
        List<String> validWords = filterInvalidWords(words);
        int count = validWords.size();
        int unique = new HashSet<>(validWords).size();
        return new WordCountResult(count, unique);
    }

    private List<String> filterInvalidWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (isValidWord(word)) {
                result.add(word);
            }
        }
        return result;
    }

    protected boolean isValidWord(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        String lowerCase = word.toLowerCase();
        if (stopWords.isStopWord(lowerCase)) {
            return false;
        }
        for (int i = 0; i < lowerCase.length(); i++) {
            char character = lowerCase.charAt(i);
            if ((character < 'a') || (character > 'z')) {
                return false;
            }
        }
        return true;
    }
}
