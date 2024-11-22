import java.util.Scanner;

public class ConsoleScanner implements InputSource{
    private static final String INPUT_PROMPT_MESSAGE = "Enter text: ";
    private final Scanner scanner;

    public ConsoleScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput(){
        System.out.print(INPUT_PROMPT_MESSAGE);
        String inputLine = scanner.nextLine();
        scanner.close();

        return inputLine;
    }
}
