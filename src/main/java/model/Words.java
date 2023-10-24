package model;

import java.util.List;

public class Words {
    private List<String> words;

    public Words(List<String> words) {
        this.words = words;
    }

    public Integer getCountedWords() {
        return words.size();
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
