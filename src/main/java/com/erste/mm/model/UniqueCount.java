package com.erste.mm.model;

import java.util.List;

public class UniqueCount {

    private final int count;
    private final long uniqueCount;
    private final double average;
    private final List<String> textualIndex;

    public UniqueCount(int count, long uniqueCount, double average, List<String> textualIndex) {
        this.count = count;
        this.uniqueCount = uniqueCount;
        this.average = average;
        this.textualIndex = textualIndex;
    }

    public int getCount() {
        return count;
    }

    public long getUniqueCount() {
        return uniqueCount;
    }

    public double getAverage() {
        return average;
    }

    public List<String> getTextualIndex() {
        return textualIndex;
    }
}
