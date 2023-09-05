package filereader;

import exception.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> readFileAsList(String fileName) {
        final URL fileResourceUrl = getFileResourceUrl(fileName);

        try {
            final File file = new File(fileResourceUrl.toURI());

            return Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {
            throw new NotFoundException(String.format("There was an error while reading the file: %s", fileName), e);
        }
    }

    private URL getFileResourceUrl(final String fileName) {
        final ClassLoader classLoader = getClass().getClassLoader();
        final URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new NotFoundException(String.format("File '%s' not found", fileName));
        }

        return resource;
    }
}
