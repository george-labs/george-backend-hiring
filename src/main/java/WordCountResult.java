public class WordCountResult {
    private Long numberOfWords;
    private Long numberOfUniqueWords;

    public WordCountResult(Long numberOfWords, Long numberOfUniqueWords) {
        this.numberOfWords = numberOfWords;
        this.numberOfUniqueWords = numberOfUniqueWords;
    }

    public Long getNumberOfWords() {
        return numberOfWords;
    }

    public Long getNumberOfUniqueWords() {
        return numberOfUniqueWords;
    }
}
