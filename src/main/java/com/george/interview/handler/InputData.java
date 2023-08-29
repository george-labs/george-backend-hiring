package com.george.interview.handler;

public class InputData {
    private String wordInput;
    private boolean indexTableAllowed;

    public InputData(String fileName, boolean index) {
        this.wordInput = fileName;
        this.indexTableAllowed = index;
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
}
