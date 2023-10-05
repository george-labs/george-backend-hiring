package io;

import counter.CounterResult;

import java.util.Arrays;
import java.util.List;

public class OutputPrinter {

    public static void printOutput(String[] args, CounterResult counterResult) {
        int numberOfWords = counterResult.getNumberOfWords();
        int numberOfUniqueWords = counterResult.getNumberOfUniqueWords();
        double averageWordLength = counterResult.getAverageWordLength();
        List<String> words = counterResult.getWords();

        String output = "Number of words: " +
                numberOfWords +
                ", unique: " +
                numberOfUniqueWords +
                "; average word length: " +
                averageWordLength +
                " characters";

        System.out.println(output);

        boolean shouldPrintIndex = Arrays.asList(args).contains("-index");

        if (shouldPrintIndex) {
            System.out.println("Index:");
            for (String word : words) {
                System.out.println(word);
            }
        }
    }
}
