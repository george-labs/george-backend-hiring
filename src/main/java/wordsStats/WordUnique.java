package wordsStats;

import java.util.HashSet;

public class WordUnique implements WordOperation<Long> {

    private final HashSet<String> wordSet;
    private long uniqueCount = 0;

    public WordUnique() {
        this.wordSet = new HashSet<>();
    }

    @Override
    public void ingestWord(String word) {
        if(!wordSet.contains(word)) {
            uniqueCount++;
            wordSet.add(word);
        }
    }

    @Override
    public String getStatSummary() {
        return "unique: " + uniqueCount;
    }

    public Long getStat() {
        return uniqueCount;
    }
}
