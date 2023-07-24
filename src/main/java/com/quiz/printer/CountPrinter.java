package com.quiz.printer;

public class CountPrinter implements Printer {
    private static final String PRINT_FORMAT = "Number of words: %s";

    @Override
    public void print(long value) {
        System.out.printf(PRINT_FORMAT, value);
    }
}
