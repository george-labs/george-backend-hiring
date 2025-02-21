import sk.erste.wordcountkata.StopWordFilter;
import sk.erste.wordcountkata.WordCounter;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        StopWordFilter stopWordFilter = new StopWordFilter("stopwords.txt");

        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        WordCounter wordCounter = new WordCounter(stopWordFilter);
        int count = wordCounter.countWords(text);

        System.out.println("Number of words: " + count);
    }

}
