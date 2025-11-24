package counter;

import counter.filter.StopWordsFilter;
import counter.model.CountingResult;
import java.util.Arrays;
import java.util.List;

public class WordCounterService implements WordCounter {

    private final StopWordsFilter stopWordsFilter;

    public WordCounterService(StopWordsFilter stopWordsFilter) {
        this.stopWordsFilter = stopWordsFilter;
    }
    public CountingResult countWords(String input) {
        if (input == null || input.isEmpty()) {
            return new CountingResult(0, 0);
        }
        //see assumption
        final List<String> words = Arrays.stream(input.split("\\s+"))
                .filter(w -> !w.isEmpty())
                .filter(stopWordsFilter::isAllowed)
                .toList();

        final long totalWords = words.size();
        final long uniqueWords = words.stream().map(String::toLowerCase).distinct().count();

        //T/Q-env: debug/trace strings
        return new CountingResult(totalWords, uniqueWords);
    }
}
