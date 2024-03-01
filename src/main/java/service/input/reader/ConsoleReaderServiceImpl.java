package service.input.reader;

import java.util.Scanner;

public class ConsoleReaderServiceImpl implements InputReaderService {
    @Override
    public String getInputText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        return scanner.nextLine();
    }
}