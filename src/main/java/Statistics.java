import com.sun.source.tree.Tree;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Statistics {
    private final Set<String> index;
    private final long wordCount;
    private final double averageWordLength;

    private Statistics(long wordCount, Set<String> index, double averageWordLength) {
        this.wordCount = wordCount;
        this.index = index;
        this.averageWordLength = averageWordLength;
    }

    public static Statistics of() {
        return new Statistics(0, Set.of(), 0);
    }

    public static Statistics of(List<String> tokenList) {
        Set<String> tokenSet = new TreeSet<>(tokenList);
        double averageWordLength = tokenList.stream().mapToDouble(String::length).average().orElse(0);

        return new Statistics(tokenList.size(), tokenSet, averageWordLength);
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getUniqueWordCount() {
        return index.size();
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public Set<String> getIndex() {
        return index;
    }
}