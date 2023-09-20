package config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IngnoredWordsReader {

    private static final String IGNORED_WORDS_FILE_PATH = "stopwords.txt";


    public Set<String> readIgnoredWords() throws IOException {
        Set<String> ignoredWords;
        try (Stream<String> filesStream = Files.lines(Paths.get(IGNORED_WORDS_FILE_PATH), StandardCharsets.UTF_8)) {
            ignoredWords = filesStream.collect(Collectors.toSet());
        }
        return ignoredWords;
    }


}
