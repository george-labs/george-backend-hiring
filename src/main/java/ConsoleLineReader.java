import java.util.Scanner;

public class ConsoleLineReader implements LineReader {
    @Override
    public String readLine() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
