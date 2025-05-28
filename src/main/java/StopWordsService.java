import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsService {

    private final TextFileReadingService textFileReadingService;

    StopWordsService(TextFileReadingService textFileReadingService) {
        this.textFileReadingService = textFileReadingService;
    }

    public Set<String> getStopWords(String stopWordsFile) {
        String stopWordsText = textFileReadingService.readFile(stopWordsFile);
        return Arrays.stream(stopWordsText.split("\\s+"))
                .map(String::trim)
                .map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toUnmodifiableSet());
    }

}
