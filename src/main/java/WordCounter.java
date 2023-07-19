import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {

    FileReader fileReader = new FileReader();

    public long countWords(String input) {
        if (input == null) {
            return 0;
        }

        return filterWords(input).size();
    }

    public long countUniqueWords(String input) {
        if (input == null) {
            return 0;
        }

        return filterWords(input).stream()
                .map(String::toLowerCase)
                .distinct()
                .count();
    }

    private List<String> filterWords(String input) {
        String[] words = input.replaceAll("[^a-zA-Z ]", "").split("\\s");
        List<String> stopWords = fileReader.readWordsFromFile("src/main/resources/stopwords.txt");

        return Arrays.stream(words)
                .filter(s -> !s.equals(""))
                .filter(s -> stopWords.stream()
                        .noneMatch(stopWord -> stopWord.equalsIgnoreCase(s)))
                .collect(Collectors.toList());
    }
}
