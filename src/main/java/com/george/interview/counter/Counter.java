package com.george.interview.counter;

import java.util.List;
import java.util.Set;

public interface Counter {
    CounterResultData count(String input, List<String> excludeWords);

    CounterResultData count(String input, List<String> excludeWords, boolean indexTableAllowed);

    CounterResultData count(String input, List<String> excludeWords, boolean indexTableAllowed, Set<String> dictionaryWords);
}
