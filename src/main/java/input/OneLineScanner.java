package input;

import java.util.Scanner;

public class OneLineScanner implements InputSource{
    private final Scanner scanner;

    public OneLineScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput(){
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
