import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Words {

    public List<String> getWords(String input) {
        if (input == null || input.isBlank()) {
            return List.of();
        }
        return Arrays.stream(input.replaceAll("\n", " ").split(" ")).filter(Words::doesMatchRegex).collect(Collectors.toList());
    }

    private static boolean doesMatchRegex(String s) {
        return s.matches("[a-zA-Z]+\\.?");
    }

    @NotNull
    public String normalizeTextWithHyphenAsSeparator(String input) {
        return input.replaceAll("-", " ");
    }

    @NotNull
    public String normalizeTextWithHyphenAsWord(String input) {
        return input.replaceAll("-", "");
    }

    public List<String> getWordsExceptStopWords(List<String> words, List<String> stopWords) {
        return words.stream().filter(word -> !stopWords.contains(word)).collect(Collectors.toList());
    }

    public List<String> getWordsWithDash(String input) {
        return Arrays.stream(new Words().normalizeTextWithHyphenAsSeparator(input).split(" "))
                .filter(s -> doesMatchRegex(s))
                .collect(Collectors.toList());
    }
}
