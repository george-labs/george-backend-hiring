import java.util.Objects;

public class AnalysisResult {

    public final int wordCount;
    public final int uniqueWordCount;
    public final Double avergeWordLength;

    public AnalysisResult(int wordCount, int uniqueWordCount, Double avergeWordLength) {
        if (wordCount < uniqueWordCount) {
            throw new IllegalStateException("Word count must be greater than or equal to unique word count");
        }
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
        this.avergeWordLength = avergeWordLength;
    }

    public AnalysisResult(Builder builder) {
        wordCount = builder.wordCount;
        uniqueWordCount = builder.uniqueWordCount;
        avergeWordLength = builder.averageWordLength;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalysisResult that = (AnalysisResult) o;
        return wordCount == that.wordCount
                && uniqueWordCount == that.uniqueWordCount
                && Math.abs(avergeWordLength - that.avergeWordLength) <= 0.000001;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordCount, uniqueWordCount, avergeWordLength);
    }

    @Override
    public String toString() {
        return "AnalysisResult{" +
                "wordCount=" + wordCount +
                ", uniqueWordCount=" + uniqueWordCount +
                ", averageIntegerCount=" + avergeWordLength +
                '}';
    }

    public static class Builder {

        private int wordCount;
        private int uniqueWordCount;
        private Double averageWordLength;

        public void setWordCount(int wordCount) {
            this.wordCount = wordCount;
        }

        public void setUniqueWordCount(int uniqueWordCount) {
            this.uniqueWordCount = uniqueWordCount;
        }

        public void setAverageWordLength(Double averageWordLength) {
            this.averageWordLength = averageWordLength;
        }

        public AnalysisResult build() {
            return new AnalysisResult(this);
        }
    }

}
