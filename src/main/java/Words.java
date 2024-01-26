import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public List<String> getWordsExceptStopWords(List<String> words) {
        return words.stream().filter(word -> {
            try {
                var url = this.getClass().getClassLoader().getResource("stopwords.txt");
                assert url != null;
                return !Files.readAllLines(Path.of(url.getPath())).contains(word);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    public List<String> getWordsWithDash(String input) {
        return Arrays.stream(new Words().normalizeTextWithHyphenAsSeparator(input).split(" "))
                .filter(s -> doesMatchRegex(s))
                .collect(Collectors.toList());
    }
}
