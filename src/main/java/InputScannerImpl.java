import java.util.Scanner;

public class InputScannerImpl implements InputScanner {

    private final Scanner scanner;

    public InputScannerImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
