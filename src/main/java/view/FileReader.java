package view;

import java.util.Scanner;

public class FileReader implements Reader{

    Scanner scanner;

    public FileReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readInput() {
        StringBuilder contentBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            contentBuilder.append(scanner.nextLine());
        }
        return contentBuilder.toString();
    }
}
