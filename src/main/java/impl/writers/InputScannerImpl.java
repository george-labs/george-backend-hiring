package impl.writers;

import api.writers.InputScanner;
import java.util.List;
import java.util.Scanner;

public class InputScannerImpl implements InputScanner {

    private final Scanner scanner;

    public InputScannerImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<String> scanInput() {
        System.out.println("Enter sentences: ");
        return List.of(scanner.nextLine());
    }
}