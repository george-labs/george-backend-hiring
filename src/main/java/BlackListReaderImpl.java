import exception.BlackListException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collection;

public class BlackListReaderImpl implements BlackListReader {

    private final BlackListReadeConfiguration blackListReadeConfiguration;

    public BlackListReaderImpl(BlackListReadeConfiguration blackListReadeConfiguration) {
        this.blackListReadeConfiguration = blackListReadeConfiguration;
    }

    @Override
    public Collection<String> getBlackList() {
        final URL blackListResourceUrl = getBlackListResourceUrl();

        try {
            final File stopWordsFile = new File(blackListResourceUrl.toURI());

            return Files.readAllLines(stopWordsFile.toPath(), StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {

            throw new BlackListException("There was an error while reading the black list file", e);
        }
    }

    private URL getBlackListResourceUrl() {
        final String stopWordsFileName = blackListReadeConfiguration.getStopWordsFileName();

        final ClassLoader classLoader = getClass().getClassLoader();
        final URL resource = classLoader.getResource(stopWordsFileName);

        if (resource == null) {
            throw new BlackListException(String.format("File '%s' not found", stopWordsFileName));
        }

        return resource;
    }
}
