package dto;

public class WordsNumbersDto {

    private long numberOfWords;
    private long uniqueNumberOfWords;

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
}
