package service.impl;

import service.UniqueWordCounterService;
import service.WordCountService;

import java.util.HashSet;
import java.util.Set;


public class UniqueWordCounterServiceImpl implements UniqueWordCounterService {

    @Override
    public int processText(String text) {
        WordCountService wordCountService = new WordCountServiceImpl();
        var countOfWord = wordCountService.getWords(text);
        Set<String> uniqueWords = new HashSet<>(countOfWord);
        return uniqueWords.size();
    }
}
