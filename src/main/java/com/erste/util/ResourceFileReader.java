package com.erste.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ResourceFileReader {

    private static final Logger log = Logger.getLogger(ResourceFileReader.class.getName());

    private final String fileLocations;

    private static final String DEFAULT_STOP_WORDS_FILE_LOCATION = "src/main/resources/";

    public ResourceFileReader() {
        fileLocations = DEFAULT_STOP_WORDS_FILE_LOCATION;
    }

    public ResourceFileReader(String resourceFolderPath) {
        fileLocations = resourceFolderPath;
    }

    public List<String> readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileLocations + filename))) {
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String readFileToString(String filename) {
        return String.join(System.lineSeparator(), readFile(filename));
    }
}
