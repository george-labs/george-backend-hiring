package bl;


import bl.model.WordStats;
import bl.providers.*;
import bl.services.WordCountService;
import bl.services.WordCountServiceImpl;

import java.util.*;

public class WordCountApp {

    private final StopWordsProvider stopWordsProvider = new StopWordsFileProvider();
    private final WordCountService wordCountService = new WordCountServiceImpl(stopWordsProvider);
    private final InputProvider inputProvider;
    boolean showIndex;

    public WordCountApp(String[] args) {
        List<String> argsSet = new ArrayList<>(Arrays.asList(args));
        this.showIndex = argsSet.contains("-index");
        argsSet.remove("-index");
        this.inputProvider = argsSet.isEmpty() ? new StdInputProvider() : new FileInputProvider(argsSet.get(0));
    }

    public void run() {
        String userInput = inputProvider.getInput();

        WordStats stats = wordCountService.countWords(userInput, showIndex);
        System.out.printf("Number of words: %d, unique: %d; average word length: %.2f characters", stats.getTotal(), stats.getUnique(), stats.getAverage());
        System.out.println();
        if (showIndex && stats.getIndex() != null) {
            System.out.println("Index:");
            for (String i : stats.getIndex()) {
                System.out.println(i);
            }
        }
    }
}
