import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordUtil {

    private static final String VALID_PATTERN = "[a-zA-Z]+";
    private static final String SEPARATOR = " ";

    private WordUtil() {

    }

    public static List<String> readFile(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        Stream<String> stringStream = Files.lines(Path.of(filePath));
        List<String[]> lines;
        try (stringStream) {
            lines = stringStream
                    .map(line -> line.split(SEPARATOR))
                    .collect(Collectors.toList());
        }
        for (String[] line : lines) {
            words.addAll(Arrays.asList(line));
        }
        return words;
    }

    public static long getWordsCount(String text) {
        String[] splitedText = text.split(SEPARATOR);
        List<String> textElements = Arrays.asList(splitedText);
        List<String> cleanedWords = getCleanedWords(textElements);
        List<String> validatedText = getValidatedText(cleanedWords);
        return validatedText.size();
    }

    public static long getWordsCount(List<String> textElements) {
        List<String> cleanedWords = getCleanedWords(textElements);
        List<String> validatedText = getValidatedText(cleanedWords);
        return validatedText.size();
    }

    public static List<String> getValidatedText(List<String> textElements) {
        return textElements.stream()
                .filter(word -> word.matches(VALID_PATTERN))
                .filter(word -> !StopWordsUtil.getStopWords().contains(word))
                .collect(Collectors.toList());
    }

    public static Set<String> getUniqueWords (List<String> textElements) {
        List<String> cleanedWords = getCleanedWords(textElements);
        List<String> validatedWords = getValidatedText(cleanedWords);
        return new HashSet<>(validatedWords);
    }

    protected static List<String> getCleanedWords (List<String> words) {
        List<String> cleanedWords = new ArrayList<>();
        for (String word: words) {
            if (word.contains("-")) {
                String[] splitedWord = word.split("-");
                cleanedWords.addAll(Arrays.asList(splitedWord));
            } else {
                cleanedWords.add(word.replace(".", ""));
            }
        }
        return cleanedWords;
    }
}
