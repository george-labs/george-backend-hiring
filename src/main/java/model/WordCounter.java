package model;

import java.util.HashSet;
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

        String[] words = tokenizeText(text);
        long count = 0;
        for(String word : words){
            if(isWord(word) && !stopWords.contains(word.toLowerCase())){
                count++;
            }
        }
        return count;
    }

    @Override
    public long uniqueWords() {
        Set<String> uniqueWords = new HashSet<>();
        String[] words = tokenizeText(text);

        for(String word : words){
            if(isWord(word) && !stopWords.contains(word.toLowerCase())){
                uniqueWords.add(word.toLowerCase());
            }
        }
        return uniqueWords.size();
    }

    private String[] tokenizeText(String text) {
        return text.replaceAll("[.,?]", "").split("[\\s-]+");
    }

    private boolean isWord(String word){
        return word.matches("^[a-zA-Z]+$");
    }
}
