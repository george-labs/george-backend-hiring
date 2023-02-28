package wordcount.stopwordsreader;

import wordcount.CriticalAppException;
import wordcount.FileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class StopWordsReader implements FileReader {

    @Override
    public List<String> read() {
        try (InputStream inputStream = Objects.requireNonNull(getClass().getClassLoader()
                .getResourceAsStream("stopwords.txt"))) {
            return List.of(new String(inputStream.readAllBytes()).split(System.lineSeparator()));
        } catch (IOException e) {
            throw new CriticalAppException("Failed to read the file with stop words");
        }
    }
}
