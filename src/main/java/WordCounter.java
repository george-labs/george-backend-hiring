import reader.StopWordsReader;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;

public class WordCounter {

    private static final String REGEX = "[a-zA-Z]+";
    private static final String WORD_DELIMITER = " ";
    private static final Pattern pattern = Pattern.compile(REGEX);

    private final StopWordsReader stopWordsReader = new StopWordsReader();

    public long count(String sentence) {
        String[] words = splitSentence(sentence);
        return countWords(words);
    }

    private long countWords(String[] words) {
        Set<String> stopWords = stopWordsReader.read();
        return Arrays.stream(words)
                .filter(word -> pattern.matcher(word).matches())
                .filter(word -> !stopWords.contains(word))
                .count();
    }

    private String[] splitSentence(String sentence) {
        return sentence.split(WORD_DELIMITER);
    }
}
