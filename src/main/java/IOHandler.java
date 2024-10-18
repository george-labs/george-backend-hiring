import java.util.Scanner;

public class IOHandler {
    Scanner inputScanner = new Scanner(System.in);

    public String getInput() {
        System.out.println("Enter text:");
        return inputScanner.nextLine();
    }
}
