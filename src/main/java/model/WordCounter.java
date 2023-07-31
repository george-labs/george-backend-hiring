package model;

import java.util.Set;

public class WordCounter implements WordAnalyzer {

    private String text;
    private Set<String> stopWords;

    public WordCounter(String text, Set<String> stopWords){
        this.text = (text != null) ? text : "";
        this.stopWords = stopWords;
    }

    @Override
    public long countWords() {

        String[] words = text.trim().split("\\s+");
        long count = 0;
        for(String word : words){
            if(isWord(word) && !stopWords.contains(word.toLowerCase())){
                count++;
            }
        }
        return count;
    }

    private boolean isWord(String word){
        return word.matches("^[a-zA-Z]+$");
    }
}
