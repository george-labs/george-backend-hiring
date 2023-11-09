package wordsStats;

public interface WordOperation<T> {

    public void ingestWord(String word);

    public String getStatSummary();

    public T getStat();
}
