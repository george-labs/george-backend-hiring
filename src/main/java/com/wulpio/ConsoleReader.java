package com.wulpio;

import java.util.Scanner;

public class ConsoleReader {

    public static String readStringFromConsole() {
        var scanner = new Scanner(System.in);
        System.out.print("Enter text: ");

        return scanner.nextLine();
    }

}
