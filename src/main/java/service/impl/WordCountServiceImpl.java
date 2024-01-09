package service.impl;

import service.WordCountService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCountServiceImpl implements WordCountService {

    @Override
    public int checkTheCountOfWord(String text){
        return getWords(text).size();
    }

    @Override
    public List<String> getWords(String text){
        var splitText = text.split(" |-|;");
        return Arrays.stream(splitText)
                .filter(s -> !s.isBlank() || !s.isEmpty())
                .filter(s -> s.matches("^[a-zA-Z.]+$"))
                .collect(Collectors.toList());
    }
}