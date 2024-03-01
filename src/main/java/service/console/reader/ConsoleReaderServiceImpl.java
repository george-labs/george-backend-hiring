package service.console.reader;

import java.util.Scanner;

public class ConsoleReaderServiceImpl implements ConsoleReaderService {
    @Override
    public String getNextLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        return scanner.nextLine();
    }
}