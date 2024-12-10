package com.erste.mm.service;

import com.erste.mm.model.Word;

import java.util.Arrays;

public class WordService {

    public static long countWords(String input) {
        return Arrays.stream(input.split(" "))
                .map(Word::new)
                .filter(Word::isLetteredWord)
                .count();
    }
}
