package service;

import java.util.Scanner;

public class InputReader implements Reader {

    @Override
    public String readInput() {
        System.out.print("Enter text: ");
        Scanner myObj = new Scanner(System.in);
        String line = myObj.nextLine();
        if (line.isBlank()) {
            System.out.println("No input provided.");
            return "";
        }
        return line;
    }
}
