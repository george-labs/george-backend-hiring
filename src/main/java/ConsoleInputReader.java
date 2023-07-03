import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    @Override
    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }
}