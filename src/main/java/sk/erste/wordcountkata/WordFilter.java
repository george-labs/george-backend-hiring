package sk.erste.wordcountkata;

public class WordFilter {

    public boolean isWordValid(String word) {
        if (word == null) {
            return false;
        }
        return word.matches("[a-zA-Z]+");
    }
}
