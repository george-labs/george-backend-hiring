package service;

import java.util.Scanner;

public class CommandService implements UserInputService {


    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");

        return scanner.nextLine();
    }

}
