package model;

public class WordCountModel {

    public WordCountModel(int wordsCount, int uniqueWordsCount) {
        this.wordsCount = wordsCount;
        this.uniqueWordsCount = uniqueWordsCount;
    }

    private int wordsCount;
    private int uniqueWordsCount;

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public int getUniqueWordsCount() {
        return uniqueWordsCount;
    }

    public void setUniqueWordsCount(int uniqueWordsCount) {
        this.uniqueWordsCount = uniqueWordsCount;
    }
}
