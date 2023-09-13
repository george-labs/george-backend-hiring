package sk.app.adaptor.ui;

import java.io.IOException;

import sk.app.application.port.outgoing.InputTextReader;
import sk.app.application.port.incoming.WordCounter;

public class InputTextUserInterface implements UserInterface {

	private final WordCounter wordCounter;
	private final InputTextReader reader;

	public InputTextUserInterface(WordCounter wordCounter, InputTextReader reader) {
		this.wordCounter = wordCounter;
		this.reader = reader;
	}

	@Override
	public void countWords() throws IOException {

		String text = reader.readText();

		System.out.println("Number of words: " + wordCounter.countWords(text));

	}
}
