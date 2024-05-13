package wordcount;

import java.util.Set;

public class WordCountService {

    private final Set<String> stopWords;

    public WordCountService(Set<String> stopWords) {
        this.stopWords = stopWords;
    }


    public int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        String[] words = sentence.split("[\\s.,?!;]+");

        int wordCount = 0;
        for (String word : words) {
            if (word.matches("[a-zA-Z]+") && !stopWords.contains(word)) {
                wordCount++;
            }
        }

        return wordCount;
    }
}
