package sk.app;

import java.util.ArrayList;
import java.util.List;

import sk.app.domain.api.incoming.WordReader;

public class ListWordReader implements WordReader {

	private final List<String> stopWords;

	public ListWordReader() {
		this(new ArrayList<>());
	}

	public ListWordReader(List<String> stopWords) {
		this.stopWords = stopWords;
	}

	@Override
	public List<String> readWords() {
		return stopWords;
	}
}
