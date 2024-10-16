package service;

import java.util.stream.Stream;

public class WordCounter {

    public int countWords(String textInput) {
        if(textInput == null || textInput.isEmpty()) {
            return 0;
        }
        String[] words = textInput.split("\\s+");
        return (int)Stream.of(words).filter(word -> word.matches("[a-zA-Z]+")).count();
    }

}
