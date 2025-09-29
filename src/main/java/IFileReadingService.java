import java.net.URL;
import java.util.List;

public interface IFileReadingService {
    URL getFileUrl(String file);
    List<String> getFileContent(String file);
}
