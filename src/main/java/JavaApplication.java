import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();

        System.out.print("Enter text: ");
        var scanner = new Scanner(System.in);
        var line = scanner.nextLine();
        System.out.print("Number od words: " + wordCounter.countWords(line));
    }
}
