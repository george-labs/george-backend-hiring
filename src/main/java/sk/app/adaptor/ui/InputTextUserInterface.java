package sk.app.adaptor.ui;

import java.io.IOException;

import sk.app.application.domain.WordCalculationService;
import sk.app.application.port.incoming.WordCalculation;
import sk.app.application.port.incoming.WordCounter;
import sk.app.application.port.outgoing.InputTextReader;

public class InputTextUserInterface implements UserInterface {

	private final WordCounter wordCounter;
	private final WordCounter uniqueWordCounter;
	private final InputTextReader reader;
	private final WordCalculation wordCalculation;

	public InputTextUserInterface(WordCounter wordCounter,
								  WordCounter uniqueWordCounter,
								  WordCalculation wordCalculation,
								  InputTextReader reader) {
		this.wordCounter = wordCounter;
		this.uniqueWordCounter = uniqueWordCounter;
		this.wordCalculation = wordCalculation;
		this.reader = reader;
	}

	@Override
	public void countWords() throws IOException {

		String text = reader.readText();

		System.out.println(String.format("Number of words: %s, unique: %s; average word length: %s",
				wordCounter.countWords(text),
				uniqueWordCounter.countWords(text),
				wordCalculation.calculateAverageWordLength(text)
				)
		);

	}
}
