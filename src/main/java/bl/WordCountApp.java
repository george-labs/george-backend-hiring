package bl;


import bl.model.WordStats;
import bl.providers.InputProvider;
import bl.providers.StopWordsFileProvider;
import bl.providers.StopWordsProvider;
import bl.services.WordCountService;
import bl.services.WordCountServiceImpl;

public class WordCountApp {

    private final StopWordsProvider stopWordsProvider = new StopWordsFileProvider();
    private final WordCountService wordCountService = new WordCountServiceImpl(stopWordsProvider);
    private final InputProvider inputProvider;

    public WordCountApp(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public void run() {
        String userInput = inputProvider.getInput();

        WordStats count = wordCountService.countWords(userInput);
        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f characters", count.getTotal(), count.getUnique(), count.getAverage());
        System.out.println();
    }
}
