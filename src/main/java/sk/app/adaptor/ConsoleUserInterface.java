package sk.app.adaptor;

import java.io.IOException;

import sk.app.adaptor.api.Reader;
import sk.app.adaptor.api.UserInterface;
import sk.app.api.WordCounter;

public class ConsoleUserInterface implements UserInterface {

	private final WordCounter wordCounter;
	private final Reader reader;

	public ConsoleUserInterface(WordCounter wordCounter, Reader reader) {
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
