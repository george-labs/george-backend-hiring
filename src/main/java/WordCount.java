import java.util.Set;


public class WordCount {

    private final FileReader fileReader;

    public WordCount(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public static int countWords(String text) {

        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = splitAndTrimInput(text);

        return words.length;
    }

    private static String[] splitAndTrimInput(String input) {
        return input.trim().toLowerCase().split("[^a-zA-Z]+");
    }

    public int countWordsExcludingStopWords(String input) throws Exception {
        Set<String> stopWords = fileReader.getStopWords();

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] words = splitAndTrimInput(input);


        int count = 0;

        for (String word : words) {
            if (word != null && !word.isEmpty() && !stopWords.contains(word)) {
                count++;
            }
        }

        return count;
    }
}
