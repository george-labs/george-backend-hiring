package com.erste.mm.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Pattern;

public class Word implements Comparable<Word> {

    private final String word;

    private static final String regex = "\\b[a-zA-Z]+(?:-[a-zA-Z]+)*\\.?";;
    private static final Pattern wordPattern  = Pattern.compile(regex);

    public Word(String word) {
        this.word = word;
    }

    public String getTextualWord() {
        return word;
    }

    public boolean isLetteredWord() {
        return getTextualWord().matches(wordPattern.pattern());
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

    @Override
    public int compareTo(@NotNull Word o) {
        return getTextualWord().length() > o.getTextualWord().length() ? 1 : -1;
    }
}
