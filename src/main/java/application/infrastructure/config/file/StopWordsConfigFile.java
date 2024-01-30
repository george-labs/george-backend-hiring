package application.infrastructure.config.file;

import application.infrastructure.config.StopWordsConfig;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class StopWordsConfigFile implements StopWordsConfig {
    private final String filePath;

    public StopWordsConfigFile(final String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> getStopWords() throws IOException {
        final List<String> stopWords = new ArrayList<>();
        final File file = new File(filePath);
        final FileInputStream fileInputStream = new FileInputStream(file);
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            while (bufferedReader.readLine() != null) {
                final String line = bufferedReader.readLine();
                stopWords.add(line);
            }
        }
        return stopWords;
    }
}
