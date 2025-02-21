package sk.erste.wordcountkata;

public class WordCounter {

    private String text;

    public WordCounter(String text) {
        this.text = text;
    }

    public int countWords() {
        String[] split = text.split("\\s+");
        int count = 0;
        for (String word : split) {
            if (new WordFilter(word).isWordValid()) {
                count++;
            }
        }
        return count;
    }
}
