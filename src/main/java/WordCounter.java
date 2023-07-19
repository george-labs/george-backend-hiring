import java.util.Arrays;
import java.util.List;

public class WordCounter {

    FileReader fileReader = new FileReader();

    public long countWords(String input) {
        if (input == null) {
            return 0;
        }

        String[] words = input.replaceAll("[^a-zA-Z ]", "").split("\\s");
        List<String> stopWords = fileReader.readWordsFromFile("src/main/resources/stopwords.txt");

        return Arrays.stream(words)
                .filter(s -> !s.equals(""))
                .filter(s -> stopWords.stream()
                        .noneMatch(stopWord -> stopWord.equalsIgnoreCase(s)))
                .count();
    }
}
