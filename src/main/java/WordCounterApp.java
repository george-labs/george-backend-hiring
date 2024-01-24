import java.util.Scanner;

public class WordCounterApp {

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        String[] words = WordCounterUtility.senteceSplitter(sentence, " ");
        int numberOfWords = WordCounterUtility.wordCounter(words);

        System.out.println("Number of words: " + numberOfWords);

    }

}
