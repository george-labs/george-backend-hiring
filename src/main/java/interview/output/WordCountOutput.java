package interview.output;

/**
 * @author : Xenofon Zinoviou
 */
public class WordCountOutput {

    int totalWords;

    public int getTotalWords() {
        return totalWords;
    }

    public WordCountOutput(int totalWords) {
        this.totalWords = totalWords;
    }

    public static WordCountOutput of(int totalWords) {
        return new WordCountOutput(totalWords);
    }
}
