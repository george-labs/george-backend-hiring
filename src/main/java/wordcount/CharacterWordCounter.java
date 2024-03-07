package wordcount;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CharacterWordCounter implements WordCounter {

	private Pattern characterRegexPattern;
	private Set<String> stopWords;

	CharacterWordCounter() {
		characterRegexPattern = Pattern.compile("[a-zA-Z]+");
	}

	/**
	 * Returns true when word is in the stopwords collection
	 * @param word
	 * @return
	 */
	private boolean filterStopWords(String word) {
		return stopWords.contains(word);
	}
	
	public void supplyStopWords(Set<String> stopWords) {
		this.stopWords = stopWords;
	}
	
	@Override
	public long countWords(String input) {
		String[] wordCandidates = input.split("\\s");
		Stream<String> wordCandidatesStream = Arrays.stream(wordCandidates);
		wordCandidatesStream = wordCandidatesStream
				.filter(candidate -> characterRegexPattern.matcher(candidate).matches())
				.filter(candidate -> filterStopWords(candidate));

		return wordCandidatesStream.count();
	}

}
