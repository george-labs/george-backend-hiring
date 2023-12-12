import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class JavaApplication {

    private InputStream input;
    private PrintStream output;


    public static void main(String args[]) {
        JavaApplication javaApplication = new JavaApplication(System.in, System.out);
        javaApplication.countWords();
    }

    public void countWords() {
        WordCounter wordCounter = new WordCounter();
        Scanner scannerInput = new Scanner(input);
        output.println("Enter the text: ");

        long wordsCount = wordCounter.count(scannerInput.nextLine());

        output.println("Number of words: " );
        output.print(wordsCount);
    }

    public JavaApplication(InputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
    }
}
