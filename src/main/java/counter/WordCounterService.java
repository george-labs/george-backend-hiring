package counter;

import java.util.Arrays;

public class WordCounterService implements WordCounter {

    public long countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        //see assumption
        final long count = Arrays.stream(input.split("\\s+"))
                .filter(w -> !w.isEmpty())
                .count();
        //T/Q-env: debug/trace strings
        return count;
    }
}
