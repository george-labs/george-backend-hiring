package dto;

import java.util.List;

public class ResultOutput {
    private int wordCount;
    private List<String> words;

    public ResultOutput(int wordCount, List<String> words) {
        this.wordCount = wordCount;
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

    public static class Builder {
        int wordCount;
        List<String> words;

       public Builder withWordCount(int wordCount) {
            this.wordCount = wordCount;
            return this;
        }

        public Builder withWords(List<String> words) {
           this.words = words;
           return this;
        }

        public ResultOutput build() {
            return new ResultOutput(wordCount, words);
        }
    }
}
