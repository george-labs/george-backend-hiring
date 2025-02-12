import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JavaApplication {

    public static void main(String[] args) {

        System.out.print("Enter the text: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String sentence = reader.readLine();
            Arrays.stream(sentence.split(" ")).filter(w)
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
