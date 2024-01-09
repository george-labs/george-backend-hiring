package service.impl;

import service.WordCountService;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WordCountServiceImpl implements WordCountService {

    @Override
    public int checkTheCountOfWord(String text){
        var splitText = text.split(" |-|;");
        var words = Arrays.stream(splitText)
                .filter(s -> !s.isBlank() || !s.isEmpty())
                .filter(s -> s.matches("^[a-zA-Z.]+$"))
                .collect(Collectors.toList());
        return words.size();
    }
}