package service;

import java.util.Scanner;

public class InputsService {

    public static String userInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
