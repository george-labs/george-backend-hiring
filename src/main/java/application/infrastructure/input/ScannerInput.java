package application.infrastructure.input;

import java.util.Scanner;

public final class ScannerInput implements Input {
    private final String consoleText;

    public ScannerInput(final String consoleText) {
        this.consoleText = consoleText;
    }

    @Override
    public String getInput() {
        System.out.println(consoleText);
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
