package interview.output;

/**
 * @author : Xenofon Zinoviou
 */
public class WordCountOutput {

    long totalWords;

    public long getTotalWords() {
        return totalWords;
    }

    public WordCountOutput(long totalWords) {
        this.totalWords = totalWords;
    }

    public static WordCountOutput of(long totalWords) {
        return new WordCountOutput(totalWords);
    }
}
