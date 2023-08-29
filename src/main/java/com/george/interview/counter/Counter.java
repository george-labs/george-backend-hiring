package com.george.interview.counter;

import java.util.List;

public interface Counter {
    Long count(String input, List<String> excludeWords);
}
