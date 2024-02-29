import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {
    public int count(String words) {
        if (words == null) {
            return 0;
        }

        String[] split = words.split("\\s+");

        if (split.length < 1) {
            return 0;
        }

        List<String> stopWords = getStopWords();

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        List<String> items = Arrays.stream(split).filter(w -> {
            Matcher matcher = pattern.matcher(w);
            return !stopWords.contains(w) && matcher.matches();
        }).collect(Collectors.toList());

        return items.size();
    }

    private List<String> getStopWords() {
        Path filePath = Path.of("stopwords.txt");
        try {
            String content = Files.readString(filePath);
            return Arrays.asList(content.split("\\n"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return Collections.emptyList();
    }
}
