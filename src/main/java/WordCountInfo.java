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
}
