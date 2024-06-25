import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        System.out.println(input);

        var wordCounter = new WordCounter();
        var result = wordCounter.countWords(input);

        System.out.print("Number of words: " + result);
    }
}
