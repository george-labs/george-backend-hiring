import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordCounter {
    private final String wordToCount;
    private final List<String> listOfWords = new ArrayList<>();
    private final List<String> listOfForbiddenWords;

    public WordCounter(String wordToCount) {
        this.wordToCount = wordToCount;
        this.listOfForbiddenWords = Collections.emptyList();
    }

    public WordCounter(String wordToCount, List<String> listOfForbiddenWords) {
        this.wordToCount = wordToCount;
        this.listOfForbiddenWords = listOfForbiddenWords;
    }

    private void filterWordsConsistingOfLetters(String word) {
        word = word.replaceAll("[^a-zA-Z-]", " ");
        String[] stringsSeparatedByWhitespace = word.split(" ");

        for (String s : stringsSeparatedByWhitespace) {
            if (s.matches("[a-zA-Z-]+") && !s.matches("-+")) {
                listOfWords.add(s);
            }
        }
    }

    private void filterForbiddenWords() {
        this.listOfWords.removeAll(this.listOfForbiddenWords);
    }

    public int countWords() {
        this.filterWordsConsistingOfLetters(this.wordToCount);
        this.filterForbiddenWords();

        return listOfWords.size();
    }

    public int countUniqueWords() {
        this.filterWordsConsistingOfLetters(this.wordToCount);
        this.filterForbiddenWords();

        return (int) listOfWords.stream().distinct().count();
    }
}
