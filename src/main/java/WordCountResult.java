public class WordCountResult {

    private final int count;
    private final int uniqueCount;

    WordCountResult(int count, int uniqueCount) {
        if ((count < 0) || (uniqueCount < 0)) {
            throw new IllegalArgumentException("Count cannot be negative number");
        }
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
