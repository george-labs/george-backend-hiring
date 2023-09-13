package sk.app.adaptor.console;

import java.io.IOException;

import sk.app.domain.api.incoming.InputTextReader;
import sk.app.domain.api.outcoming.UserInterface;
import sk.app.domain.api.WordCounter;

public class ConsoleUserInterface implements UserInterface {

	private final WordCounter wordCounter;
	private final InputTextReader reader;

	public ConsoleUserInterface(WordCounter wordCounter, InputTextReader reader) {
		this.wordCounter = wordCounter;
		this.reader = reader;
	}

	@Override
	public void countWords() throws IOException {
		System.out.print("Enter text: ");

		String text = reader.readText();

		System.out.println("Number of words: " + wordCounter.countWords(text));

	}
}
