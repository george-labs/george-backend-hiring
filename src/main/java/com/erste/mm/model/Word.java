package com.erste.mm.model;

import java.util.Objects;

public class Word {

    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public String getTextualWord() {
        return word;
    }

    public boolean isLetteredWord() {
        for (char ch : word.toCharArray())
            if (!Character.isLetter(ch))
                return false;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }
}
