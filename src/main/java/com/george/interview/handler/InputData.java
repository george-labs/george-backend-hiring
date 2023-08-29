package com.george.interview.handler;

import java.util.Set;

public class InputData {
    private String wordInput;
    private boolean indexTableAllowed;
    private Set<String> dictionaryWords;

    public InputData(String fileName, boolean index, Set<String> dictionaryWords) {
        this.wordInput = fileName;
        this.indexTableAllowed = index;
        this.dictionaryWords = dictionaryWords;
    }

    public String getWordInput() {
        return wordInput;
    }

    public void setWordInput(String wordInput) {
        this.wordInput = wordInput;
    }

    public boolean isIndexTableAllowed() {
        return indexTableAllowed;
    }

    public void setIndexTableAllowed(boolean indexTableAllowed) {
        this.indexTableAllowed = indexTableAllowed;
    }

    public Set<String> getDictionaryWords() {
        return dictionaryWords;
    }

    public void setDictionaryWords(Set<String> dictionaryWords) {
        this.dictionaryWords = dictionaryWords;
    }
}
