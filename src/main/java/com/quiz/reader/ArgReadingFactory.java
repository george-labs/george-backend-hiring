package com.quiz.reader;

public class ArgReadingFactory {
    public Reader create(String[] args) {
        if (args == null || args.length == 0) {
            return new ConsoleReader();
        } else {
            return new FileReader(args[0]);
        }
    }
}
