package sk.adaptor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sk.app.WordCounter;

public class ConsoleUserInterface {

	private final WordCounter wordCounter;

	public ConsoleUserInterface(WordCounter wordCounter) {
		this.wordCounter = wordCounter;
	}

	public void countWords() throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		String text = reader.readLine();

		System.out.println("Number of words: " + wordCounter.countWords(text));

	}
}
