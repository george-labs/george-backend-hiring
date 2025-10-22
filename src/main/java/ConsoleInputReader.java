import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    @Override
    public String readInput(String ignored) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        return line;
    }
}
