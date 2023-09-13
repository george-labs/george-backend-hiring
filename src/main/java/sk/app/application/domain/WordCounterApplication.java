package sk.app.application.domain;

import sk.app.application.port.incoming.WordCounter;
import sk.app.application.api.WordFilter;

public class WordCounterApplication implements WordCounter {

	private final WordFilter wordFilter;

	public WordCounterApplication(WordFilter wordFilter) {
		this.wordFilter = wordFilter;
	}

	@Override
	public int countWords(String text) {
		if (text == null) {
			return 0;
		}
		String[] tokens = text.split("\\s+");

		int counter = 0;
		for (String token : tokens) {
			if (isWord(token)) {
				counter++;
			}
		}

		return counter;
	}

	private boolean isWord(String token) {
		if (token.isBlank() || wordFilter.isStopWord(token)) {
			return false;
		}
		for (int i = 0; i < token.length(); i++) {
			char character = token.charAt(i);
			if (!Character.isLetter(character)) {
				return false;
			}
		}
		return true;
	}
}
