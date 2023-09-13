package sk.app.application.domain;

import sk.app.application.api.WordFilter;
import sk.app.application.port.incoming.WordCounter;

public class WordCounterService extends WordCounterBase implements WordCounter {

	public WordCounterService(WordFilter wordFilter) {
		super(wordFilter);
	}

	@Override
	public int countWords(String text) {
		return findAllWords(text).size();
	}
}
