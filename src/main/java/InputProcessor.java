import java.io.InputStream;
import java.util.Scanner;

public class InputProcessor {

    private InputStream inputStream;

    public InputProcessor(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String readInput() {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextLine();
    }
}
