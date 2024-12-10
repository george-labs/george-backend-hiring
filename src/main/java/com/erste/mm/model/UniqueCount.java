package com.erste.mm.model;

public class UniqueCount {

    private final int count;
    private final long uniqueCount;

    public UniqueCount(int count, long uniqueCount) {
        this.count = count;
        this.uniqueCount = uniqueCount;
    }

    public int getCount() {
        return count;
    }

    public long getUniqueCount() {
        return uniqueCount;
    }
}
