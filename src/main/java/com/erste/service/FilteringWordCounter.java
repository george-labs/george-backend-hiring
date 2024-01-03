package com.erste.service;

public class FilteringWordCounter implements WordCounter {
    @Override
    public int countWords(String string) {
        String inputWith = replaceLinebreaksWithWhitespaces(string);
        return 0;
    }

    private String replaceLinebreaksWithWhitespaces(String string) {
        return null;
    }
}
