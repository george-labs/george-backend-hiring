import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaApplication {

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Enter text: ");
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String input = null;
        try{
            input = reader.readLine();
        }
        catch (IOException x) {
            System.err.println("Could not read input. Something happend");
        }

        System.out.println(input);

    }
}
