package george.coding.challenge.job;

/**
 * Container for keeping parser results
 *
 * @param wordCount
 */
public record Result(
        // count of words
        int wordCount,
        // count of unique words
        int uniqueWordCount,
        // average length of word
        double averageLength) {

    public Result {
        if (wordCount < 0) {
            throw new IllegalArgumentException("Word count cannot be negative");
        }
        if (uniqueWordCount < 0) {
            throw new IllegalArgumentException("Unique word count cannot be negative");
        }
        if (uniqueWordCount > wordCount) {
            throw new IllegalArgumentException("Unique word count cannot be higher than word count");
        }
    }
}
