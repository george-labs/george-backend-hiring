package com.erste.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ResourceFileReader {

    private static final Logger log = Logger.getLogger(ResourceFileReader.class.getName());

    private static final String STOP_WORDS_FILE_LOCATION = "src/resources/";

    public List<String> readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(STOP_WORDS_FILE_LOCATION + filename))) {
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            log.log(Level.WARNING, e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
