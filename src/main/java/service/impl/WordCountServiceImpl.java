package service.impl;

import service.WordCountService;

import static service.utils.TextUtils.getWords;


public class WordCountServiceImpl implements WordCountService {

    @Override
    public int checkTheCountOfWord(String text){
        return getWords(text).size();
    }
}