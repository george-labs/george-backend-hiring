package com.george.interview;

import com.george.interview.processor.Processor;
import com.george.interview.processor.WordProcessor;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Processor processor = new WordProcessor();
        System.out.println("Enter text:");
        String userInput  = scanner.nextLine();
        processor.process(userInput);
    }
}
