package service.integration;

import java.util.Scanner;

public class SystemTextService implements ITextService {
    private static final String WELCOME_TEXT = "Enter text:";

    @Override
    public String getString() {
        System.out.println(WELCOME_TEXT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
