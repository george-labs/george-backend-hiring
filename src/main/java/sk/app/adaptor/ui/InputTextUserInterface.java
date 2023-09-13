package sk.app.adaptor.ui;

import java.io.IOException;

import sk.app.application.port.incoming.WordCounter;
import sk.app.application.port.outgoing.InputTextReader;

public class InputTextUserInterface implements UserInterface {

	private final WordCounter wordCounter;
	private final WordCounter uniqueWordCounter;
	private final InputTextReader reader;

	public InputTextUserInterface(WordCounter wordCounter, WordCounter uniqueWordCounter, InputTextReader reader) {
		this.wordCounter = wordCounter;
		this.uniqueWordCounter = uniqueWordCounter;
		this.reader = reader;
	}

	@Override
	public void countWords() throws IOException {

		String text = reader.readText();

		System.out.println(String.format("Number of words: %s, unique: %s", wordCounter.countWords(text), uniqueWordCounter.countWords(text)));

	}
}
