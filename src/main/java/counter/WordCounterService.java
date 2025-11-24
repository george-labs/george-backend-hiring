package counter;

import counter.filter.StopWordsFilter;
import java.util.Arrays;

public class WordCounterService implements WordCounter {

    private final StopWordsFilter stopWordsFilter;

    public WordCounterService(StopWordsFilter stopWordsFilter) {
        this.stopWordsFilter = stopWordsFilter;
    }
    public long countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        //see assumption
        final long count = Arrays.stream(input.split("\\s+"))
                .filter(w -> !w.isEmpty())
                .filter(stopWordsFilter::isAllowed)
                .count();
        //T/Q-env: debug/trace strings
        return count;
    }
}
