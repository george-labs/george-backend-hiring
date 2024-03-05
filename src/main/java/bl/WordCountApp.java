package bl;


import bl.model.WordStats;
import bl.providers.*;
import bl.services.WordStatsService;
import bl.services.WordStatsServiceImpl;

import java.util.*;

public class WordCountApp {

    private static final String INDEX_ARG = "-index";
    private final StopWordsProvider stopWordsProvider = new StopWordsFileProvider();
    private final WordStatsService wordStatsService = new WordStatsServiceImpl(stopWordsProvider);
    private final InputProvider inputProvider;
    boolean showIndex;

    public WordCountApp(String[] args) {
        List<String> argsList = new ArrayList<>(Arrays.asList(args));
        this.showIndex = argsList.contains(INDEX_ARG);
        argsList.remove(INDEX_ARG);

        if (argsList.size() > 1) {
            throw new IllegalArgumentException("There are unexpected arguments.");
        }
        this.inputProvider = argsList.isEmpty() ? new StdInputProvider() : new FileInputProvider(argsList.get(0));
    }

    public void run() {
        String userInput = inputProvider.getInput();

        WordStats stats = wordStatsService.countWords(userInput, showIndex);
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
