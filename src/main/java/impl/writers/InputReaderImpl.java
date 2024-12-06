package impl.writers;

import api.writers.InputReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InputReaderImpl implements InputReader {

    private final Scanner scanner;

    public InputReaderImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<String> readInput() {
        System.out.println("Enter sentences: ");
        return List.of(scanner.nextLine());
    }

    @Override
    public List<String> readInput(String filePath) throws IOException {
        return List.of();
    }
}