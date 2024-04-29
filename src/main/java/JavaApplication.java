import java.util.Scanner;
import java.util.StringTokenizer;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        //read input
        System.out.print("Enter text: ");
        String textInput = console.nextLine();

        //output output
        System.out.println("Number of words: " + countWords(textInput));
    }

    public static int countWords(String textInput) {
        StringTokenizer tokenizer = new StringTokenizer(textInput);

        int wordCount = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.matches("[a-zA-Z]+")) wordCount++;
        }

        return wordCount;
    }
}
