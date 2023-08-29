package com.george.interview.counter;

public class CounterResultData {
    private Long count;
    private Double averageWordLength;
    private Long countUnique;

    public CounterResultData(Long count, Long countUnique, Double averageWordLength) {
        this.count = count;
        this.countUnique = countUnique;
        this.averageWordLength = averageWordLength;
    }

    public Long getCount() {
        return count;
    }

    public Long getCountUnique() {
        return countUnique;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(Double averageWordLength) {
        this.averageWordLength = averageWordLength;
    }

    public void setCountUnique(Long countUnique) {
        this.countUnique = countUnique;
    }
}
