package service;

import dto.ResultOutput;
import exception.InvalidInputException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class WordAnalysisServiceImpl implements WordAnalysisService {

    @Override
    public ResultOutput analyze(String inputString) {
        List<String> ignorableWords = readIgnorableWords();

        List<String> words = getWords(sanitizeString(inputString))
                .stream()
                .filter(input -> !input.isBlank())
                .filter(word -> !ignorableWords.contains(word))
                .toList();


        return new ResultOutput
                .Builder()
                .withWordCount(words.size())
                .withWords(words)
                .build();
    }

    private List<String> readIgnorableWords() {
       try {
         return Files.readAllLines(Path.of("stopwords.txt"));
       } catch (IOException e) {
               throw new InvalidInputException("File could not be found");
       }
    }

    private String sanitizeString(String inputString) {
        return inputString.replaceAll("[^a-zA-Z ]", "");
    }

    private List<String> getWords(String inputString) {
        return Arrays
                .stream(inputString
                .split(" "))
                .toList();
    }
}
