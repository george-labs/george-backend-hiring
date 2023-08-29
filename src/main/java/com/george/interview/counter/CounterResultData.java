package com.george.interview.counter;

public class CounterResultData {
    private Long count;
    private Long countUnique;

    public CounterResultData(Long count, Long countUnique) {
        this.count = count;
        this.countUnique = countUnique;
    }

    public Long getCount() {
        return count;
    }

    public Long getCountUnique() {
        return countUnique;
    }
}
