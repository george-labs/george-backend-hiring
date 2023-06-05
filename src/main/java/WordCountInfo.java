import java.util.Objects;

public class WordCountInfo {

    private int countOfAllWords;
    private int countOfUniqueWords;

    public WordCountInfo(int countOfAllWords, int countOfUniqueWords) {
        this.countOfAllWords = countOfAllWords;
        this.countOfUniqueWords = countOfUniqueWords;
    }

    public int getCountOfAllWords() {
        return countOfAllWords;
    }

    public int getCountOfUniqueWords() {
        return countOfUniqueWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCountInfo that = (WordCountInfo) o;
        return getCountOfAllWords() == that.getCountOfAllWords() && getCountOfUniqueWords() == that.getCountOfUniqueWords();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountOfAllWords(), getCountOfUniqueWords());
    }
}
