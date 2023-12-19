import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        var ignoredWords = new IgnoredWords();
        WordCounter wordCounter = new WordCounter(ignoredWords.getIgnoredWords("stopwords.txt"));
        if (args.length == 0) {
            var scanner = new Scanner(System.in);
            System.out.print("Enter text: ");
            var line = scanner.nextLine();
            printResult(wordCounter.countWords(line));
        } else {
            printResult(wordCounter.countWordsFromFile(args[0]));
        }
    }

    private static void printResult(WordCount wordCount) {
        System.out.print(
                "Number of words: " + wordCount.getWordCount() + ", unique: " + wordCount.getUniqueWords() + ", average word length: " + wordCount.getAverageWordLength() + " characters");
    }

}
