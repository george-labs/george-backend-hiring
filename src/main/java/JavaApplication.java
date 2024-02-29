import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String line = scanner.nextLine();
        WordCounter wordCounter = new WordCounter(new StopWords(new FileReader()));
        System.out.println("Number of words: " + wordCounter.count(line));
    }
}
