import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();

        System.out.print("Enter text: ");

        Scanner sc = new Scanner(System.in);

        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            long wordCount = wordCounter.countWords(line);

            System.out.printf("Number of words: %d%n", wordCount);
        }
    }
}
