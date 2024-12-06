package com.erste.mm.service;

import com.erste.mm.model.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WordService {

    public static long countWords(String input) {
        return Arrays.stream(input.split(" "))
                .map(Word::new)
                .filter(Word::isLetteredWord)
                .count();
    }

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
