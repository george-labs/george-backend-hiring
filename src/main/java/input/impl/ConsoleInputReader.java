package input.impl;

import input.InputReader;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    @Override
    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
