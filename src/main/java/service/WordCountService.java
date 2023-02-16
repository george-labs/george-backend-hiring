package service;

import dto.WordCountResultDto;
import io.IFileHandler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCountService {

    private final Set<String> stopWords;

    private final IFileHandler fileHandler;

    public WordCountService(IFileHandler fileHandler) {
        this.fileHandler = fileHandler;
        stopWords = fileHandler.populateStopWords();
    }

    public WordCountResultDto countWords(String inputFileName) {
        String input = fileHandler.getInput(inputFileName);

        validateInput(input);

        WordCountResultDto result = getWordCount(input);

        System.out.println("Number of words: " + result.getCount() + ", unique: " + result.getUniqueCount());
        return result;
    }

    private WordCountResultDto getWordCount(String input) {
        String[] split = input.split(" ");

        List<String> filteredInput = Arrays.stream(split)
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());
        Set<String> uniqueInput = new HashSet<>(filteredInput);

        return new WordCountResultDto(filteredInput.size(), uniqueInput.size());
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new RuntimeException("The input string is blank!");
        }

        //TODO needs updating the regex for e.g. ---
        boolean valid = input.matches("[a-zA-Z -]+");
        if (!valid) {
            throw new RuntimeException("The input string contains invalid character(s)!");
        }
    }

}
