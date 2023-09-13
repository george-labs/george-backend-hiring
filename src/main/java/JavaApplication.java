import java.io.IOException;

import sk.app.adaptor.console.ConsoleUserInterface;
import sk.app.adaptor.word.reader.FileWordResourceReader;
import sk.app.adaptor.console.InputReader;
import sk.app.domain.WordCounterApplication;
import sk.app.domain.WordFilterService;
import sk.app.domain.api.WordCounter;
import sk.app.domain.api.WordFilter;
import sk.app.domain.api.outcoming.UserInterface;

public class JavaApplication {

	public static void main(String[] args) throws IOException {

		WordFilter wordFilter = new WordFilterService(new FileWordResourceReader("stopwords.txt"));
		WordCounter wordCounter = new WordCounterApplication(wordFilter);

		UserInterface consoleUserInterface = new ConsoleUserInterface(wordCounter, new InputReader());

		consoleUserInterface.countWords();
	}
}
