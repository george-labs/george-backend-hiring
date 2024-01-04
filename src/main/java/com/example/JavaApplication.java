package com.example;

public class JavaApplication {
    public static void main(String ... args) {
        Task task = new IterationOneTask();
        task.readInput();
        task.validate();
        task.process();
    }
}
