import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Enter text: ");
        String userInput = scan.nextLine();

        int wordCount = getWordCount(userInput);

        System.out.println("Number of words: " + wordCount);
    }

    public static int getWordCount(String userInput) {
//        return (int) Arrays.stream(userInput.split("[^a-zA-Z]")).filter(token ->  null != token && !token.isEmpty()).count();
        return (int) Arrays.stream(
                userInput.split("\\s"))
                .filter(token -> token.matches("[a-zA-Z]"))
                .filter(token ->  null != token && !token.isEmpty())
        .count();
    }
}
