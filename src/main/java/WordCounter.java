import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {

    FileReader fileReader = new FileReader();

    public long countWords(List<String> words) {
        if (words == null) {
            return 0;
        }

        return words.size();
    }

    public long countUniqueWords(List<String> words) {
        if (words == null || words.isEmpty()) {
            return 0;
        }

        return words.stream()
                .map(String::toLowerCase)
                .distinct()
                .count();
    }

    public double countAvgLength(List<String> words) {
        if (words == null || words.isEmpty()) {
            return 0;
        }

        return (Math.round(words.stream()
                .mapToDouble(String::length)
                .average()
                .getAsDouble() * 100d) / 100d);
    }

    public List<String> filterWords(String input) {
        if (input == null) {
            return new ArrayList<>();
        }

        String[] words = input.replaceAll("[^a-zA-Z -]", " ").split("\\s");
        List<String> stopWords = fileReader.readWordsFromFile("src/main/resources/stopwords.txt");

        return Arrays.stream(words)
                .filter(s -> !s.equals(""))
                .filter(s -> stopWords.stream()
                        .noneMatch(stopWord -> stopWord.equalsIgnoreCase(s)))
                .collect(Collectors.toList());
    }
}
