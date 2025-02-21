package sk.erste.wordcountkata;

public class WordFilter {

    private final String word;

    public WordFilter(String word) {
        this.word = word;
    }

    public boolean isWordValid() {
        if (word == null) {
            return false;
        }
        return word.matches("[a-zA-Z]+");
    }
}
