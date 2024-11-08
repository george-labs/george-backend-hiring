import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WordCounter {

    private final String text;

    /**
     * Creates new wordcounter instance that will be based on given text.
     *
     * @param text Text with which word counter will be working with.
     * */
    WordCounter(String text) {
        this.text = Objects.requireNonNull(text, "Text cannot be null");
    }

    /**
     * Returns count of words (letters only) for its text.
     *
     * @return Number of words containing only letters
     * */
    public int  countWords() {
        //split according spaces
        String[] crudeWords = this.text.split("\\s+");

        //filter out letter words only
        List<String> filteredWords = Arrays.stream(crudeWords)
                .filter(word -> word.matches("^[a-zA-Z]+$"))
                .toList();

        return filteredWords.size();
    }
}
