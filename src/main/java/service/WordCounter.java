package service;

import java.util.stream.Stream;

public class WordCounter {

    public int countWords(String textInput) {
        if(textInput == null || textInput.isEmpty()) {
            return 0;
        }
        String[] words = textInput.split("\\s+");
        int wordsCount = 0;
        Stream<String> wordsStream = Stream.of(words);
        wordsCount = (int)wordsStream.filter(word -> word.matches("[a-zA-Z]+")).count();
        return wordsCount;
    }

}
