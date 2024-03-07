package wordcount;

import java.util.Arrays;
import java.util.stream.Stream;

public class SimpleWordCounter implements WordCounter {

	@Override
	public long countWords(String input) {
		String[] wordCandidates = input.split("\\s");
		Stream<String> wordCandidatesStream = Arrays.stream(wordCandidates);
		wordCandidatesStream = wordCandidatesStream.filter(candidate -> candidate.matches("[a-zA-Z]+")); // TODO refactor -> regexp compile
		return wordCandidatesStream.count(); 
	}

}
