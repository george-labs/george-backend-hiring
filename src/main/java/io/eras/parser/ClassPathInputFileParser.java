package io.eras.parser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassPathInputFileParser implements InputParser {

    private String filename;

    public ClassPathInputFileParser(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> parse() {
        try (Stream<String> lines = Files.lines(Path.of(ClassLoader.getSystemResource(this.filename).toURI()))) {
            return lines
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
