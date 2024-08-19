package com.geogre.wordcount;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleInputFetcher implements InputFetcher {

    @Override
    public String fetch() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException ex) {
            System.out.println();
        }
        return "";
    }
}
