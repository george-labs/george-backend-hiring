import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {

        var ignoredWords = new IgnoredWords();
        WordCounter wordCounter = new WordCounter(ignoredWords.getIgnoredWords("stopwords.txt"),
                new ParamParserImpl(args), new InputScannerImpl(new Scanner(System.in)));
        wordCounter.countWords();
    }

}
