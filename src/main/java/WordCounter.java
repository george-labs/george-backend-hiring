import util.PrintResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordCounter {
    private final String text;
    private final List<String> listOfWords = new ArrayList<>();
    private final List<String> listOfStopWords;

    public WordCounter(String text) {
        this.text = text;
        this.listOfStopWords = Collections.emptyList();
    }

    public WordCounter(String text, List<String> listOfStopWords) {
        this.text = text;
        this.listOfStopWords = listOfStopWords;
    }

    private void filterWordsConsistingOfLetters(String text) {
        text = text.replaceAll("[^a-zA-Z-]", " ");
        String[] potentialWords = text.split(" ");

        for (String s : potentialWords) {
            if (s.matches("[a-zA-Z-]+") && !s.matches("-+")) {
                listOfWords.add(s);
            }
        }
    }

    private void filterForbiddenWords() {
        this.listOfWords.removeAll(this.listOfStopWords);
    }

    public int countWords() {
        this.filterWordsConsistingOfLetters(this.text);
        this.filterForbiddenWords();

        return listOfWords.size();
    }

    public int countUniqueWords() {
        this.filterWordsConsistingOfLetters(this.text);
        this.filterForbiddenWords();

        return (int) listOfWords.stream().distinct().count();
    }

    public double countAverageWordLength() {
        double sum = 0;
        int numberOfWords = countWords();

        for (String word : listOfWords) {
            sum += word.length();
        }

        return Math.floor((sum / numberOfWords) * 100) / 100;
    }

    public PrintResult count() {
        return new PrintResult(countWords(),
                countUniqueWords(),
                countAverageWordLength());
    }
}
