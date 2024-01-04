package com.example;

import java.util.*;

import static java.util.Objects.isNull;

public class IterationOneTask implements Task{
    protected String userInput;

    @Override
    public void readInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            userInput = scanner.nextLine();
        }
    }

    @Override
    public void validate() {
        if (isNull(userInput)) {
            throw new IllegalStateException("read input first");
        }
    }

    @Override
    public void process() {
        System.out.println("Number of words: " + parse().length);
    }

    protected String [] parse() {
        return filterEmptyWords(userInput.split("[^a-zA-Z]+"));
    }

    private String[] filterEmptyWords(String[] split) {
        List<String> valid = new ArrayList<>(split.length);
        for (String word: split) {
            if (!"".equals(word)) {
                valid.add(word);
            }
        }
        return valid.toArray(new String[valid.size()]);
    }
}
