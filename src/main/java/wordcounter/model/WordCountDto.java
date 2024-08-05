package wordcounter.model;

import java.util.ArrayList;
import java.util.List;

public class WordCountDto {

    private long count;
    private long unique;
    private double averageLength;
    private List<String> countedWords = new ArrayList<String>();

    public WordCountDto(long count, long unique, double averageLength, List<String> countedWords) {
        this.count = count;
        this.unique = unique;
        this.averageLength = averageLength;
        this.countedWords = countedWords;
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

    public List<String> getCountedWords() {
        return countedWords;
    }

    public void setCountedWords(List<String> countedWords) {
        this.countedWords = countedWords;
    }
}
