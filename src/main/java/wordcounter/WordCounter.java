package wordcounter;

import java.util.List;

public class WordCounter {

    public long countWords(String text) {
        List<String> words = splitText(text);
        return words.stream()
                .filter(this::isValidWord)
                .count();
    }

    private List<String> splitText(String text) {
        String[] words = text.split("[\\s.?!,]+");
        return List.of(words);
    }

    private boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }

}
