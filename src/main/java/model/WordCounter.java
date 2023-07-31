package model;

public class WordCounter implements WordAnalyzer {

    private String text;

    public WordCounter(String text){
        this.text = (text != null) ? text : "";
    }

    @Override
    public long countWords() {

        String[] words = text.trim().split("\\s+");
        long count = 0;
        for(String word : words){
            if(isWord(word)){
                count++;
            }
        }
        return count;
    }

    private boolean isWord(String word){
        return word.matches("^[a-zA-Z]+$");
    }
}
