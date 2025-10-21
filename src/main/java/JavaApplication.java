import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter text: ");
        String userInput = scan.nextLine();

        int wordCount = getWordCount(userInput);

        System.out.println("Number of words: " + wordCount);
    }

    private static int getWordCount(String userInput) {

        return 5;


    }
}
