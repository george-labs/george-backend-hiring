import java.util.ArrayList;
import java.util.List;

public class WordCounter {
    private final String wordToCount;
    private final List<String> listOfWords = new ArrayList<>();

    public WordCounter(String wordToCount) {
        this.wordToCount = wordToCount;
    }

    private void filterWordsConsistingOfLetters(String word) {
        String[] stringsSeparatedByWhitespace = word.split(" ");

        for (String s : stringsSeparatedByWhitespace) {
            if (s.matches("[a-zA-Z]+")) {
                listOfWords.add(s);
            }
        }
    }

    public int countWords() {
        this.filterWordsConsistingOfLetters(this.wordToCount);

        return listOfWords.size();
    }
}
