import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WordCounter {

    public CountResponse count(String line, List<String> stopWords) {
        String[] splittedLine = processLineToArray(line);
        if (splittedLine.length == 1 && "".equals(splittedLine[0])) {
            return new CountResponse();
        }
        Set<String> unique = new LinkedHashSet<>();
        List<String> allWords = new ArrayList<>();
        for (String word : splittedLine) {
            if (stopWords.contains(word)){
                continue;
            }

            unique.add(word);
            allWords.add(word);
        }

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
                .replaceAll("-", " ")
                .split(" ");
    }
}
