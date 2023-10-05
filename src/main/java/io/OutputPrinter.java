package io;

import counter.CounterResult;

public class OutputPrinter {

    public static void printOutput(CounterResult counterResult) {
        int numberOfWords = counterResult.getNumberOfWords();
        int numberOfUniqueWords = counterResult.getNumberOfUniqueWords();
        double averageWordLength = counterResult.getAverageWordLength();

        String output = "Number of words: " +
                numberOfWords +
                ", unique: " +
                numberOfUniqueWords +
                "; average word length: " +
                averageWordLength +
                " characters";

        System.out.println(output);
    }
}
