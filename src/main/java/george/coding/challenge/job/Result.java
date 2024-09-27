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
}
