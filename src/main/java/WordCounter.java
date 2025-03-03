import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WordCounter {

    public CountResponse count(String line, List<String> stopWords) {
        if (line == null || "".equals(line)) {
            return new CountResponse();
        }
        List<String> allWords = Arrays.stream(processLineToArray(line))
                .filter(word -> !stopWords.contains(word))
                .toList();

        Set<String> unique = new LinkedHashSet<>(allWords);

        CountResponse response = new CountResponse();
        response.setUniqueCount(unique.size());
        response.setTotalCount(allWords.size());

        return response;
    }

    @NotNull
    private static String[] processLineToArray(String line) {
        return line
                .trim()                                      // cut spaces at the start and end of the string
                .replaceAll("\\s+", " ")     // replace more spaces by one
                .split(" ");
    }
}
