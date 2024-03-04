import java.util.Scanner;

public class WordCounterConsoleResolver implements WordCounterResolver {
    @Override
    public String resolve() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        return scanner.nextLine();
    }
}
