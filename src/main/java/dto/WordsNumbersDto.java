package dto;

public class WordsNumbersDto {

    private long numberOfWords;
    private long uniqueNumberOfWords;
    private double averageLength;

    public void setNumberOfWords(long numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    public long getNumberOfWords() {
        return numberOfWords;
    }

    public void setUniqueNumberOfWords(long uniqueNumberOfWords) {
        this.uniqueNumberOfWords = uniqueNumberOfWords;
    }

    public long getUniqueNumberOfWords() {
        return uniqueNumberOfWords;
    }

    public void setAverageLength(double averageLength) {
        this.averageLength = averageLength;
    }

    public double getAverageLength() {
        return averageLength;
    }
}
