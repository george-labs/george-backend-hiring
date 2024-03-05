package bl;

import bl.model.AppArgs;
import bl.model.WordStats;
import bl.providers.*;
import bl.services.WordStatsService;
import bl.services.WordStatsServiceImpl;

public class WordCountApp {

    private final StopWordsProvider stopWordsProvider = new StopWordsFileProvider();
    private final WordStatsService wordStatsService = new WordStatsServiceImpl(stopWordsProvider);
    private final InputProvider inputProvider;
    private final AppArgs appArgs;

    public WordCountApp(String[] args) {
        this.appArgs = AppArgs.parse(args);
        this.inputProvider = this.appArgs.getFileName() == null ? new StdInputProvider() : new FileInputProvider(this.appArgs.getFileName());
    }

    public void run() {
        String userInput = inputProvider.getInput();
        WordStats stats = wordStatsService.countWords(userInput, this.appArgs.isShowIndex());
        printStats(stats);
    }

    private void printStats(WordStats stats) {
        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f characters", stats.getTotal(), stats.getUnique(), stats.getAverage());
        System.out.println();
        if (stats.getIndex() != null) {
            System.out.println("Index:");
            for (String i : stats.getIndex()) {
                System.out.println(i);
            }
        }
    }
}
