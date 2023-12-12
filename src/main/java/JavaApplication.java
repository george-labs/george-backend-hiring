import java.util.Scanner;

public class JavaApplication {

    public static void main(String args[]) {
        WordCounter wordCounter = new WordCounter();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the text: ");

        long wordsCount = wordCounter.count(input.nextLine());
        System.out.println("Number of words: " + wordsCount);
    }

}
