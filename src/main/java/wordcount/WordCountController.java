package wordcount;

import wordcount.counter.CharacterWordCounter;
import wordcount.counter.FilteredWordCounter;
import wordcount.io.FileReader;
import wordcount.ui.ConsoleUserInterface;
import wordcount.ui.UserInterface;

public class WordCountController {
	private static final String STOPWORDS_DEFAULT_FILENAME = "stopwords.txt";

	private UserInterface ui;
	private FilteredWordCounter wordCounter;

	WordCountController() {
		ui = new ConsoleUserInterface();
		wordCounter = new CharacterWordCounter();
		wordCounter.loadStopWords(FileReader.readUniqueLines(STOPWORDS_DEFAULT_FILENAME));
	}

	void run() {
		String userInput = ui.readUserInput();
		long wordCount = wordCounter.countWords(userInput);
		ui.presentOutput(wordCount);
	}
}
