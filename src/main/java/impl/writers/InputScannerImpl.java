package impl.writers;

import static impl.writers.utils.InputScannerUtil.filterInputWords;
import static impl.writers.utils.InputScannerUtil.readFile;

import api.writers.InputScanner;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputScannerImpl implements InputScanner {

        private final Scanner scanner;

    public InputScannerImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int scanInput() {
        System.out.println("Enter sentences: ");
        String userInput = scanner.nextLine();
        final var split = Arrays.asList(userInput.split("\\s"));

        List<String> forbiddenWords = readFile();
        List<String> list = filterInputWords(split, forbiddenWords);
        return list.size();
    }
}