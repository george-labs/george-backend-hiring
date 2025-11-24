package counter;

import counter.filter.StopWordsFilter;
import counter.model.CountingResult;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounterService implements WordCounter {

    public static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+([a-zA-Z-]+[a-zA-Z])?");

    private final StopWordsFilter stopWordsFilter;

    public WordCounterService(StopWordsFilter stopWordsFilter) {
        this.stopWordsFilter = stopWordsFilter;
    }
    public CountingResult countWords(String input) {
        if (input == null || input.isEmpty()) {
            return new CountingResult(0, 0);
        }
        List<String> words = new ArrayList<>();

        Matcher matcher = WORD_PATTERN.matcher(input);

        while (matcher.find()) {
            String word = matcher.group();
            if (stopWordsFilter.isAllowed(word)) {
                words.add(word);
            }
        }

        final long totalWords = words.size();
        final long uniqueWords = words.stream().map(String::toLowerCase).distinct().count();

        //T/Q-env: debug/trace strings
        return new CountingResult(totalWords, uniqueWords);
    }
}
