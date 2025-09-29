import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StopWordReadingService{
    private final IFileReadingService readingService;

    public StopWordReadingService() {
        this.readingService = new FileReadingService();
    }
    
    public Set<String> getStopWords(String file) {
        return new HashSet<>(readingService.getFileContent(file));
    }
}
