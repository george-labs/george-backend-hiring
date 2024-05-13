import wordcount.WordCount;

import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String sentence = scanner.nextLine();

        WordCount wordCount = new WordCount();
        System.out.println("Number of words: " + wordCount.countWords(sentence));
    }
}
