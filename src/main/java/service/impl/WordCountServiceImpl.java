package service.impl;

import service.WordCountService;

public class WordCountServiceImpl implements WordCountService {

    @Override
    public int checkTheCountOfWord(String text){
        var splitText = text.split(" |-|;");
        int counter = 0;
        for (String s : splitText) {
            if (s.matches("^[a-zA-Z.]+$")) {
                counter++;
            }
        }
        return counter;
    }
}