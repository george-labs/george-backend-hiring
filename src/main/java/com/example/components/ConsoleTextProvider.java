package com.example.components;

import java.util.Scanner;

public class ConsoleTextProvider implements ITextProvider {

    private final Scanner scanner;

    public ConsoleTextProvider() {
        this.scanner = new Scanner(System.in);
    }

    public String getInputText() {
        System.out.println("Enter text: ");
        return scanner.nextLine();
    }

}
