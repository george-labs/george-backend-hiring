import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter text: ");
        String inputText = scanner.nextLine();

        var wordCountingService = new WordCountingService();
        var wordCount = wordCountingService.countWords(inputText);

        System.out.println("Number of words: " + wordCount);
    }

}
