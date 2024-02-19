import java.util.*;

public class WordCounter {

    private static final Set<char> SUPPORTED_PUNCTIONAL_MARKS = {'-', '.'};

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
        String lowerCaseWord = word.toLowerCase();
        if (stopWords.isStopWord(lowerCaseWord)) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char character = lowerCaseWord.charAt(i);
            if ((character < 'a') || (character > 'z') || (character != '-') || (character != '.')) {
                return false;
            }
        }
        if (word.length() == 1) {

        }
        return true;
    }


}
