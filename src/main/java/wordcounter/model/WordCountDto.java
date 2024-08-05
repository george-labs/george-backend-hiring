package wordcounter.model;

public class WordCountDto {

    private long count;
    private long unique;

    public WordCountDto(long count, long unique) {
        this.count = count;
        this.unique = unique;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getUnique() {
        return unique;
    }

    public void setUnique(long unique) {
        this.unique = unique;
    }
}
