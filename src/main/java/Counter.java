public class Counter {

    private long count = 0;
    private long countUnique = 0;

    public Counter(long count, long countUnique) {
        this.count = count;
        this.countUnique = countUnique;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCountUnique() {
        return countUnique;
    }

    public void setCountUnique(long countUnique) {
        this.countUnique = countUnique;
    }
}
