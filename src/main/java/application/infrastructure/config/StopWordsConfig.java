package application.infrastructure.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface StopWordsConfig {
    List<String> getStopWords() throws IOException;
}
