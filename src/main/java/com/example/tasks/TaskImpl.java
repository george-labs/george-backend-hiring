package com.example.tasks;

import com.example.utils.predicates.IsStopWord;
import com.example.utils.predicates.IsNotEmpty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;

import static com.example.utils.Utils.readFile;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class TaskImpl implements Task{
    protected String userInput;
    private String[] args;
    protected Predicate<String> filters;


    public TaskImpl(String [] args, List<String> stopWords) {
        this.args = args;
        filters = new IsNotEmpty()
                .and(Predicate.not(new IsStopWord(stopWords)));
    }

    @Override
    public void readInput() {
        if (nonNull(args) && args.length > 0) { // use Optional???
            readInputFromFile(args[0]);
        } else {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter text: ");
                userInput = scanner.nextLine();
            }
        }
    }

    private void readInputFromFile(String file) {
        userInput = readFile(file);
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
        return applyFilters(userInput.split("[^a-zA-Z]+"));
    }

    private String[] applyFilters(String[] split) {
        List<String> valid = new ArrayList<>(split.length);
        for (String word: split) {
            if (filters.test(word)) {
                valid.add(word);
            }
        }
        return valid.toArray(new String[valid.size()]);
    }
}
