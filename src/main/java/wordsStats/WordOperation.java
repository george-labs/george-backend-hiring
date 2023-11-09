package wordsStats;

public interface WordOperation {

    public void ingestWord(String word);

    public String getStatSummary();
}
