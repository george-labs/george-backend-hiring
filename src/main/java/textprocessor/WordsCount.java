package textprocessor;

public class WordsCount {
    private int count;
    private int uniqueCount;

    public WordsCount(int count, int uniqueCount) {
        this.count = count;
        this.uniqueCount = uniqueCount;
    }

    public int getCount() {
        return count;
    }

    public int getUniqueCount() {
        return uniqueCount;
    }
}
