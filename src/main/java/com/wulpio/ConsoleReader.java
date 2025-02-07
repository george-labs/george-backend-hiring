package com.wulpio;

import java.util.Scanner;

public class ConsoleReader {

    public static String readFromConsole() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter text: ");

        return myObj.nextLine();
    }

}
