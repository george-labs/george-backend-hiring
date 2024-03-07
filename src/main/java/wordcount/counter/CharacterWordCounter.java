package wordcount.counter;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CharacterWordCounter implements FilteredWordCounter {

	private Pattern characterRegexPattern;
	private Set<String> stopWords;

	public CharacterWordCounter() {
		characterRegexPattern = Pattern.compile("[a-zA-Z]+");
	}

	/**
	 * Returns true when word is in the stopwords collection
	 * 
	 * @param word
	 * @return
	 */
	private boolean filterStopWords(String word) {
		if ( stopWords != null ) { 
			return !stopWords.contains(word);
		} 
		return true;
	}

	@Override
	public void loadStopWords(Set<String> stopWords) {
		this.stopWords = stopWords;
	}

	@Override
	public long countWords(String input) {
		String[] wordCandidates = input.split("\\s");
		Stream<String> wordCandidatesStream = Arrays.stream(wordCandidates);
		wordCandidatesStream = wordCandidatesStream
				.filter(candidate -> characterRegexPattern.matcher(candidate).matches())
				.filter(this::filterStopWords);

		return wordCandidatesStream.count();
	}

}
