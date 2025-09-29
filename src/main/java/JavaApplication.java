import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String userInput = scanner.nextLine();

        int numberOfWords = WordCountService.countWordsInString(userInput);

        System.out.println("Number of words: " + numberOfWords);
    }


}
