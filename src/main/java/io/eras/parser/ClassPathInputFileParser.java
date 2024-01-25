package io.eras.parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassPathInputFileParser {

    private String filename;

    public ClassPathInputFileParser(String filename) {
        this.filename = filename;
    }

    public Set<String> parse() {
        try (Stream<String> lines = Files.lines(Path.of(ClassLoader.getSystemResource(this.filename).toURI()))) {
            return lines
                    .collect(Collectors.toSet());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
