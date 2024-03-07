package wordcount;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CharacterWordCounter implements WordCounter {

	private Pattern characterRegexPattern;

	CharacterWordCounter() {
		characterRegexPattern = Pattern.compile("[a-zA-Z]+");
	}

	@Override
	public long countWords(String input) {
		String[] wordCandidates = input.split("\\s");
		Stream<String> wordCandidatesStream = Arrays.stream(wordCandidates);
		wordCandidatesStream = wordCandidatesStream
				.filter(candidate -> characterRegexPattern.matcher(candidate).matches());

		return wordCandidatesStream.count();
	}

}
