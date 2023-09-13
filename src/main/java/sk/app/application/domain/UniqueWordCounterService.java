package sk.app.application.domain;

import java.util.HashSet;

import sk.app.application.api.WordFilter;
import sk.app.application.port.incoming.WordCounter;

public class UniqueWordCounterService extends WordCounterBase implements WordCounter {

	public UniqueWordCounterService(WordFilter wordFilter) {
		super(wordFilter);
	}

	@Override
	public int countWords(String text) {
		return new HashSet<>(findAllWords(text)).size();
	}
}
