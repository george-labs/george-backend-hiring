import java.util.HashSet;
import java.util.Set;

public class StopWordReadingService{
    private final IFileReadingService readingService;

    public StopWordReadingService(IFileReadingService readingService) {
        this.readingService = readingService;
    }

    public Set<String> getStopWords(String file) {
        return new HashSet<>(readingService.getFileContent(file));
    }
}
