package domain;

public class CountResult {
    final int count;
    final int uniqueCount;

    public CountResult(int count, int uniqCount) {
        this.count = count;
        this.uniqueCount = uniqCount;
    }

    public int getCount() {
        return count;
    }

    public int getUniqueCount() {
        return uniqueCount;
    }
}
