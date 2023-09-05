import java.util.Set;

public interface WordCounter {

    /**
     * Takes a user input string and counts all alphabetical words
     * @param inputSentence user input string
     * @param stopWords set of stop words (e.g blacklist) which should not be counted as words
     * @return number of words
     */
    long countWords(String inputSentence, Set<String> stopWords);

}
