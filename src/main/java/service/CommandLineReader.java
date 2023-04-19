package service;

import java.util.Scanner;

public class CommandLineReader implements Reader {
    Scanner scanner;

    public CommandLineReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }
}
