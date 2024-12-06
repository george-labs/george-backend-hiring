package com.erste.mm.component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public static List<String> readWordsInput(String input) {
        return readFileOnPath(Paths.get(input));
    }

    public static List<String> readBuildInStopWords(String input) {
        return readFileOnPath(Paths.get("src", "main", "resources", input));
    }

    public static List<String> readFileOnPath(Path readPath) {
        try {
            return Files.readAllLines(readPath);
        } catch (IOException e) {
            System.out.println("could not read stopwords.txt file");
            return List.of();
        }
    }
}
