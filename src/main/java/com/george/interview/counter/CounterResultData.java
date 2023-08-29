package com.george.interview.counter;

import java.util.List;

public class CounterResultData {
    private Long count;
    private Double averageWordLength;
    private Long countUnique;

    private List<String> indexTable;

    public CounterResultData(Long count, Long countUnique, Double averageWordLength, List<String> indexTable) {
        this.count = count;
        this.countUnique = countUnique;
        this.averageWordLength = averageWordLength;
        this.indexTable = indexTable;
    }

    public List<String> getIndexTable() {
        return indexTable;
    }

    public void setIndexTable(List<String> indexTable) {
        this.indexTable = indexTable;
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
