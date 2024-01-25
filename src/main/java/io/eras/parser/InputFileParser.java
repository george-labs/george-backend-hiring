package io.eras.parser;

import io.eras.util.WordCounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputFileParser implements InputParser {

    private String path;

    private WordCounter wordCounter;

    public InputFileParser(String path, WordCounter wordCounter) {
        this.path = path;
        this.wordCounter = wordCounter;
    }

    public long parse() {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines
                    .map(wordCounter::countWords)
                    .reduce(0L, Long::sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
