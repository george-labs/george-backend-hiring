package com.george.interview;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Counter counter = new WordCounter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String userInput  = scanner.nextLine();
        System.out.println("Number of words: " + counter.count(userInput));
    }
}
