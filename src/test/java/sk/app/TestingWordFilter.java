package sk.app;

import java.util.ArrayList;
import java.util.List;

import sk.app.api.WordFilter;

public class TestingWordFilter implements WordFilter {

	private final List<String> stopWords;

	public TestingWordFilter() {
		this(new ArrayList<>());
	}

	public TestingWordFilter(List<String> stopWords) {
		this.stopWords = stopWords;
	}

	@Override
	public boolean isStopWord(String word) {
		if (word == null || stopWords == null) {
			return false;
		}
		return stopWords.contains(word);
	}
}
