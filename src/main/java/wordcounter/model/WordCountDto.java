package wordcounter.model;

public class WordCountDto {

    private long count;
    private long unique;
    private double averageLength;

    public WordCountDto(long count, long unique, double averageLength) {
        this.count = count;
        this.unique = unique;
        this.averageLength = averageLength;
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

    public double getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(double averageLength) {
        this.averageLength = averageLength;
    }

}
