package wordcount;

import wordcount.counter.CharacterWordCounter;
import wordcount.counter.FilteredWordCounter;
import wordcount.io.FileReader;
import wordcount.ui.ConsoleInputReader;
import wordcount.ui.ConsoleWriter;
import wordcount.ui.UserInputReader;
import wordcount.ui.UserInputReaderFactory;
import wordcount.ui.UserOutputWriter;

public class WordCountController {
	private static final String STOPWORDS_DEFAULT_FILENAME = "stopwords.txt";

	private UserInputReader userInputReader;
	private UserOutputWriter userOutputWriter;
	private FilteredWordCounter wordCounter;

	WordCountController(String[] args) {
		userInputReader = UserInputReaderFactory.getInputReader(args);
		userOutputWriter = new ConsoleWriter();
		wordCounter = new CharacterWordCounter();
		wordCounter.loadStopWords(FileReader.readUniqueLines(STOPWORDS_DEFAULT_FILENAME));
	}

	void run() {
		String userInput = userInputReader.readUserInput();
		long wordCount = wordCounter.countWords(userInput);
		userOutputWriter.presentOutput(wordCount);
	}
}
