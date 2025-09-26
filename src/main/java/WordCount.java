import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {

        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println("Number of words: " + countWords(input));
    }

    public static int countWords(String text) {

        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.trim().split("[^a-zA-Z]+");

        return words.length;
    }
}
