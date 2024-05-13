package wordcount;

public class WordCount {
    public int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        String[] words = sentence.split("[\\s.,?!;]+");

        int wordCount = 0;
        for (String word : words) {
            if (word.matches("[a-zA-Z]+")) {
                wordCount++;
            }
        }

        return wordCount;
    }
}
