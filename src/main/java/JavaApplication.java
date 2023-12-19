import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        var paramParser = new ParamParser(args);

        var ignoredWords = new IgnoredWords();
        WordCounter wordCounter = new WordCounter(ignoredWords.getIgnoredWords("stopwords.txt"), paramParser.shouldCreateIndex());
        if (paramParser.getFileName().isPresent()) {
            var scanner = new Scanner(System.in);
            System.out.print("Enter text: ");
            var line = scanner.nextLine();
            printResult(wordCounter.countWords(line));
        } else {
            printResult(wordCounter.countWordsFromFile(paramParser.getFileName().get()));
        }
    }

    private static void printResult(WordCount wordCount) {
        System.out.print(
                "Number of words: " + wordCount.getWordCount() + ", unique: " + wordCount.getUniqueWords() + ", average word length: " + wordCount.getAverageWordLength() + " characters");
        if (!wordCount.getCountedWords().isEmpty()) {
            System.out.println("Index:");
            wordCount.getCountedWords().forEach(System.out::println);
        }
    }

}
