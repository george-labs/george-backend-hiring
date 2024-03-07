package wordcount.counter;

public class WordCountResult {
	private final long numberOfWords;
	private final long numberOfUniqueWords;

	public WordCountResult(long numberOfWords, long numberOfUniqueWords) {
		this.numberOfWords = numberOfWords;
		this.numberOfUniqueWords = numberOfUniqueWords;
	}

	public long getNumberOfWords() {
		return numberOfWords;
	}


	public long getNumberOfUniqueWords() {
		return numberOfUniqueWords;
	}


}
