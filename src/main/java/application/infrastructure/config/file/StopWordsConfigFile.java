package application.infrastructure.config.file;

import application.infrastructure.config.StopWordsConfig;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class StopWordsConfigFile implements StopWordsConfig {
    private final String resourceFileName;

    public StopWordsConfigFile(final String resourceFileName) {
        this.resourceFileName = resourceFileName;
    }

    @Override
    public List<String> getStopWords() {
        if (resourceFileName == null) {
            return new ArrayList<>();
        }
        try {
            return getDataFromFile();
        } catch (IOException e) {
            System.out.println("No config file");
            return new ArrayList<>();
        }
    }

    private List<String> getDataFromFile() throws IOException {
        final List<String> stopWords = new ArrayList<>();
        final ClassLoader classLoader = getClass().getClassLoader();
        final InputStream inputStream = classLoader.getResourceAsStream(resourceFileName);

        if (inputStream == null) {
            return new ArrayList<>();
        }

        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stopWords.add(line);
            }
        }
        return stopWords;
    }
}
