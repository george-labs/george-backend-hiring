package input;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    @Override
    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
