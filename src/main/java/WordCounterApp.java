import java.util.Scanner;

public class WordCounterApp {

    public static void main(String[] args) {
        System.out.println("Please enter the sentece");
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        String[] words = WordCounterUtility.senteceSplitter(sentence, " ");
        int numberOfWords = WordCounterUtility.wordCounter(words);

        System.out.println("Words number " + numberOfWords);

    }

}
