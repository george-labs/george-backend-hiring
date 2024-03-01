import repository.FileReader;
import repository.StopWordsProvider;
import repository.StopWordsProviderImpl;
import service.counting.words.CountingWordsService;
import service.counting.words.CountingWordsServiceImpl;
import service.input.reader.InputReaderServiceProvider;

public class JavaApplication {
    public static void main(String[] args) {
        StopWordsProvider stopWordsProvider = new StopWordsProviderImpl(new FileReader(), "stopwords.txt");

        InputReaderServiceProvider provider = new InputReaderServiceProvider();

        CountingWordsService countingWordsServiceImpl = new CountingWordsServiceImpl(stopWordsProvider, provider.getProvider(args));

        System.out.println("Number of words: " + countingWordsServiceImpl.countNumberOfWords());
        System.out.println("Number of words: " + countingWordsServiceImpl.countNumberOfWords());
    }
}
