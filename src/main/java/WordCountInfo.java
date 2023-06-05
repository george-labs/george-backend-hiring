import java.util.Objects;

public class WordCountInfo {

    private int countOfAllWords;
    private int countOfUniqueWords;
    private double averageLength;

    public WordCountInfo(int countOfAllWords, int countOfUniqueWords, double averageLength) {
        this.countOfAllWords = countOfAllWords;
        this.countOfUniqueWords = countOfUniqueWords;
        this.averageLength = averageLength;
    }

    public int getCountOfAllWords() {
        return countOfAllWords;
    }

    public int getCountOfUniqueWords() {
        return countOfUniqueWords;
    }

    public double getAverageLength() {
        return averageLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCountInfo that = (WordCountInfo) o;
        return getCountOfAllWords() == that.getCountOfAllWords() && getCountOfUniqueWords() == that.getCountOfUniqueWords() && getAverageLength() == that.getAverageLength();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountOfAllWords(), getCountOfUniqueWords(), getAverageLength());
    }

    @Override
    public String toString() {
        return "WordCountInfo{" +
                "countOfAllWords=" + countOfAllWords +
                ", countOfUniqueWords=" + countOfUniqueWords +
                ", averageLength=" + averageLength +
                '}';
    }
}
