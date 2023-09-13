import java.io.IOException;

import sk.app.adaptor.ConsoleUserInterface;
import sk.app.adaptor.FileWordFilter;
import sk.app.adaptor.InputReader;
import sk.app.adaptor.api.UserInterface;
import sk.app.api.WordCounter;
import sk.app.domain.WordCounterApplication;

public class JavaApplication {

	public static void main(String[] args) throws IOException {

		WordCounter wordCounter = new WordCounterApplication(new FileWordFilter("stopwords.txt"));
		UserInterface consoleUserInterface = new ConsoleUserInterface(wordCounter, new InputReader());

		consoleUserInterface.countWords();
	}
}
