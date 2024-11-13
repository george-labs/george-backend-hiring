import java.util.List;
import java.util.Objects;
import java.util.Set;

public class AnalysisResult {

    public final int wordCount;
    public final int uniqueWordCount;
    public final Double avergeWordLength;
    public final List<String> indexedWords;

    public AnalysisResult(int wordCount, int uniqueWordCount, Double avergeWordLength, List<String> indexedWords) {
        if (wordCount < uniqueWordCount) {
            throw new IllegalStateException("Word count must be greater than or equal to unique word count");
        }
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
        this.avergeWordLength = avergeWordLength;
        this.indexedWords = indexedWords;
    }

    @Override
    public String toString() {
        return "AnalysisResult{" +
                "wordCount=" + wordCount +
                ", uniqueWordCount=" + uniqueWordCount +
                ", avergeWordLength=" + avergeWordLength +
                ", indexedWords=" + indexedWords +
                '}';
    }
}
