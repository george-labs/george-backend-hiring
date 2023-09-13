package sk.app.adaptor.input;

import java.io.IOException;

import sk.app.domain.api.incoming.InputTextReader;
import sk.app.domain.api.WordCounter;
import sk.app.domain.api.outcoming.UserInterface;

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
