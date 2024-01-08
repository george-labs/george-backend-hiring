import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter text:");

        String inputText = myObj.nextLine();

        WordCounter wordCounter = new WordCounter(inputText);
        System.out.println("Number of words: " + wordCounter.get());

    }
}
