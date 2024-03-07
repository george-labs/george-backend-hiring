package wordcount;

import wordcount.ui.ConsoleUserInterface;
import wordcount.ui.UserInterface;

public class WordCountController {
	private UserInterface ui;
	private WordCounter wordCounter;

	WordCountController() {
		ui = new ConsoleUserInterface();
		wordCounter = new CharacterWordCounter();
	}

	void run() {
		String userInput = ui.readUserInput();
		long wordCount = wordCounter.countWords(userInput);
		ui.presentOutput(wordCount);
	}
}
