package dto;

import java.util.List;

public class ResultOutput {
    private int wordCount;
    private int uniqueCount;
    private List<String> words;

    public ResultOutput(int wordCount, int uniqueCount,  List<String> words) {
        this.wordCount = wordCount;
        this.uniqueCount = uniqueCount;
        this.words = words;
    }

    public ResultOutput() {
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getUniqueCount() {
        return uniqueCount;
    }

    public static class Builder {
        int wordCount;
        List<String> words;
        int uniqueCount;

       public Builder withWordCount(int wordCount) {
            this.wordCount = wordCount;
            return this;
        }

        public Builder withWords(List<String> words) {
           this.words = words;
           return this;
        }

        public Builder withUniqueCount(int uniqueCount) {
           this.uniqueCount = uniqueCount;
           return this;
        }

        public ResultOutput build() {
            return new ResultOutput(wordCount, uniqueCount, words);
        }
    }
}
