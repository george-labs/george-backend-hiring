package sourceprovider;

import java.util.Scanner;

public class ConsoleTextProvider implements TextProvider {
    @Override
    public String provide() {
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
