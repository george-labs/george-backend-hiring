import java.io.IOException;

import sk.adaptor.ConsoleUserInterface;
import sk.app.WordCounter;
import sk.app.WordCounterApplication;

public class JavaApplication {

	public static void main(String[] args) throws IOException {

		WordCounter wordCounter = new WordCounterApplication();
		ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface(wordCounter);

		consoleUserInterface.countWords();
	}
}
