import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemTextReader implements TextReader {

    @Override
    public List<String> read() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text:");
        String inputText = scanner.nextLine();
        List<String> lines = new ArrayList<>();
        lines.add(inputText);
        return lines;
    }
}
