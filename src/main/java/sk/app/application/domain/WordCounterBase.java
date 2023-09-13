package sk.app.application.domain;

import java.util.ArrayList;
import java.util.List;

import sk.app.application.api.WordFilter;

abstract class WordCounterBase {

	private final WordFilter wordFilter;

	public WordCounterBase(WordFilter wordFilter) {
		this.wordFilter = wordFilter;
	}

	protected List<String> findAllWords(String text) {
		if (text == null) {
			return new ArrayList<>();
		}
		List<String> words = new ArrayList<>();
		String[] tokens = text.split("[\\s+]");

		for (String token : tokens) {
			if (isWord(token)) {
				words.add(token);
			}
		}
		return words;
	}

	private boolean isWord(String token) {
		if (token.isBlank() || wordFilter.isStopWord(token)) {
			return false;
		}
		for (int i = 0; i < token.length(); i++) {
			char character = token.charAt(i);
			if (i == token.length() -1 && character == '.') {
				return true;
			}
			if (!Character.isLetter(character) && character != '-') {
				return false;
			}
		}
		return true;
	}
}
