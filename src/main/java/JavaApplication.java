import kotlin.text.Regex;

import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) {
        final WordCounter wordCounter = new WordCounter();
        final Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        final Integer numberOfWords = wordCounter.countWordsInLine(line, new Regex("[A-Za-z]+") );
        System.out.println(numberOfWords);
    }
}
