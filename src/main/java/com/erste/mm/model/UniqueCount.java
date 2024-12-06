package com.erste.mm.model;

public class UniqueCount {

    private final int count;
    private final long uniqueCount;
    private final double average;

    public UniqueCount(int count, long uniqueCount, double average) {
        this.count = count;
        this.uniqueCount = uniqueCount;
        this.average = average;
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
}
