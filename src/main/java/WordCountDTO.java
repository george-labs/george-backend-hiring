import java.util.Objects;

public class WordCountDTO {

    @Override
    public String toString() {
        return String.format("Number of words: %s, unique: %s", count, unique_count);
    }

    WordCountDTO(int count, int unique_count){
        this.count = count;
        this.unique_count = unique_count;
    }

    private final int count;
    private final int unique_count;

    public int getCount() {
        return count;
    }

    public int getUnique_count() {
        return unique_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCountDTO that = (WordCountDTO) o;
        return count == that.count && unique_count == that.unique_count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, unique_count);
    }
}
