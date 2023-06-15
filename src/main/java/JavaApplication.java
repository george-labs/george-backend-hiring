import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter(readFromInput());

        System.out.println("Number of words: " +  wordCounter.countWords());
    }

    private static String readFromInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");

        return sc.nextLine();
    }
}
