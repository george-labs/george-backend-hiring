package com.erste.mm.component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StopWordsReader {

    public static List<String> readStopWords(String input) {
        Path path = Paths.get("src", "main", "resources", input);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("could not read stopwords.txt file");
            return List.of();
        }
    }
}
