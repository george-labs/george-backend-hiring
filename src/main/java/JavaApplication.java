import sourceprovider.TextProvider;
import sourceprovider.TextProviderStrategyImpl;
import textprocessor.StopWordsChecker;
import textprocessor.StopWordsCheckerImpl;
import textprocessor.WordCounterImpl;
import textprocessor.WordsCounter;

public class JavaApplication {
    public static void main(String[] args) {
        try {
            TextProvider textProvider = new TextProviderStrategyImpl().getProvider(args.length > 0 ? args[0] : "");

            StopWordsChecker stopWordsChecker = new StopWordsCheckerImpl("src/main/resources/stopwords.txt");
            WordsCounter counter = new WordCounterImpl(stopWordsChecker);

            System.out.println("Number of words: " + counter.countWords(textProvider.provide()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
