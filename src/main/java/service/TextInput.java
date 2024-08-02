package service;

import java.util.Scanner;

public class TextInput implements UserInput {

    private Scanner scanner;

    public TextInput() {
    }

    @Override
    public String provideInput() {
        System.out.print("Enter text: ");
        this.scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
