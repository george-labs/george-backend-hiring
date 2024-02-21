import sourceprovider.TextProvider;
import sourceprovider.TextProviderStrategyImpl;
import textprocessor.*;

public class JavaApplication {
    public static void main(String[] args) {
        try {
            TextProvider textProvider = new TextProviderStrategyImpl().getProvider(args.length > 0 ? args[0] : "");

            StopWordsChecker stopWordsChecker = new StopWordsCheckerImpl("src/main/resources/stopwords.txt");
            UniqueWordsCounter counter = new UniqueWordsCounterImpl(stopWordsChecker);
            WordsCount count = counter.countWords(textProvider.provide());
            System.out.println("Number of words: " + count.getCount() + ", unique: " + count.getUniqueCount());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
