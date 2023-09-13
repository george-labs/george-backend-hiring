package sk.app.domain;

import java.util.List;

import sk.app.domain.api.WordFilter;
import sk.app.domain.api.incoming.WordReader;

public class WordFilterService implements WordFilter {

	private final List<String> stopWords;

	public WordFilterService(WordReader wordReader) {
		this.stopWords = wordReader.readWords();
	}

	@Override
	public boolean isStopWord(String word) {
		return stopWords.stream().anyMatch(line -> line.equals(word));
	}

}
