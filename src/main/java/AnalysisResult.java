import java.util.Objects;

public class AnalysisResult {

    public final int wordCount;
    public final int uniqueWordCount;

    public AnalysisResult(int wordCount, int uniqueWordCount) {
        if (wordCount < uniqueWordCount) {
            throw new IllegalStateException("Word count must be greater than or equal to unique word count");
        }
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalysisResult that = (AnalysisResult) o;
        return wordCount == that.wordCount && uniqueWordCount == that.uniqueWordCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordCount, uniqueWordCount);
    }
}
