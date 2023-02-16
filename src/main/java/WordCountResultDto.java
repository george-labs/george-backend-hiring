public class WordCountResultDto {

    private final int count;
    private final int uniqueCount;

    public WordCountResultDto(int count, int uniqueCount) {
        this.count = count;
        this.uniqueCount = uniqueCount;
    }

    public int getCount() {
        return count;
    }

    public int getUniqueCount() {
        return uniqueCount;
    }
}
