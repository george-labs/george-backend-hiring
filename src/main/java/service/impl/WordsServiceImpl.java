package service.impl;

import service.WordsService;

import java.util.List;

public class WordsServiceImpl implements WordsService {

    @Override
    public int countWords(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }

        if (text.isBlank()) return 0;

        List<String> words = List.of(text.split("\\s+"));
        return (int) words.stream().filter(word -> word.matches("[a-zA-Z]+")).count();
    }

}
