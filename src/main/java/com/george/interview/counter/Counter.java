package com.george.interview.counter;

import java.util.List;

public interface Counter {
    CounterResultData count(String input, List<String> excludeWords);

    CounterResultData count(String input, List<String> excludeWords, boolean indexTableAllowed);
}
