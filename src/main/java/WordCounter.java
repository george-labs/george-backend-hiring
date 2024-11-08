import java.util.List;
import java.util.Objects;

public class WordCounter {

    private final List<String> words;

    /**
     * Creates new word counter instance that can count letter words.
     *
     * @param words TList of words with which word counter will be working with.
     * */
    WordCounter(List<String> words) {
        this.words = Objects.requireNonNull(words, "Words cannot be null");
    }



    /**
     * Returns count of words (letters only) for its text.
     *
     * @return Number of words containing only letters
     * */
    public int  countWords(List<String> stopWords) {
        //filter out letter words only
        List<String> filteredWords = words.stream()
                .filter(word -> word.matches("^[a-zA-Z]+$") && !stopWords.contains(word))
                .toList();

        return filteredWords.size();
    }
}
