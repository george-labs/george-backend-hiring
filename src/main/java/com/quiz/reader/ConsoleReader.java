package com.quiz.reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public String read() {
        System.out.print("Enter text: ");
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();

        return text;
    }
}
