package com.erste.mm.model;

public class Word {

    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public String getTextualWord() {
        return word;
    }

    public boolean isLetteredWord() {

        for (char ch : word.toCharArray()) {

            if (!Character.isLetter(ch))
                return false;

        }

        return true;
    }
}
