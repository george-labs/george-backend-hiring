package dto;

public class ResultOutput {
    private int wordCount;

    public ResultOutput(int wordCount) {
        this.wordCount = wordCount;
    }

    public ResultOutput() {
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public static class Builder {
        int wordCount;

        Builder withWorCount(int wordCount) {
            this.wordCount = wordCount;
            return this;
        }

        ResultOutput build() {
            return new ResultOutput(wordCount);
        }
    }
}
