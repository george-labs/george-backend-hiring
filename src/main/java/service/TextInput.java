package service;

import java.util.Scanner;

public class TextInput {

    private Scanner scanner;

    public TextInput() {
    }

    public void askForInput() {
        System.out.println("Enter text:");
        this.scanner = new Scanner(System.in);
    }

    public String read() {
        return scanner.nextLine();
    }
}
