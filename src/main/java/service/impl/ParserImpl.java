package service.impl;

import model.Input;
import model.Words;
import service.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserImpl implements Parser {

    @Override
    public Words parse(Input input) {
        return countWords(input);
    }

    private Words countWords(Input input) {
        List<String> words = splitIntoWords(input);
        return new Words(words);
    }

    private List<String> splitIntoWords(Input input) {
        return Arrays.stream(input.getInput().split(" "))
                .filter(this::isAlphabetical)
                .collect(Collectors.toList());
    }

    private boolean isAlphabetical(String word) {
        return word.matches("[a-zA-Z]+");
    }
}
