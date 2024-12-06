package impl.writers;

import api.writers.InputScanner;
import java.util.Scanner;

public class InputScannerImpl implements InputScanner {

    public InputScannerImpl() {
    }

    @Override
    public int scanInput() {
        System.out.println("Enter sentences: ");
        String userInput = new Scanner(System.in).nextLine();
        int countedWords = userInput.split("\\s").length;
        return countedWords;

    }

}