package service.impl;

import service.WordsService;

import java.util.List;

public class WordsCountImpl implements WordsService {

    @Override
    public int countWords(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }

        if (text.isBlank()) return 0;


    }

}
