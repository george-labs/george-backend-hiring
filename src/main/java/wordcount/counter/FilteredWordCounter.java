package wordcount.counter;

import java.util.Set;

public interface FilteredWordCounter {
	// returns a count of words in input string
	public WordCountResult countWords(String input);
	
	// load stopwords used to filter the word list
	public void loadStopWords(Set<String> stopWords);
}
