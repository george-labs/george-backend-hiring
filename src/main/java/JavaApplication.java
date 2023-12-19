import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();

        System.out.print("Enter text: ");
        var scanner = new Scanner(System.in);
        var line = scanner.nextLine();
        var ignoredWords = new IgnoredWords();
        System.out.print("Number od words: " + wordCounter.countWords(line, ignoredWords.getIgnoredWords("stopwords.txt")));
    }


}
