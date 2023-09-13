import java.io.IOException;

import sk.app.adaptor.input.InputReaderFactory;
import sk.app.adaptor.input.InputTextUserInterface;
import sk.app.adaptor.word.reader.FileWordResourceReader;
import sk.app.domain.WordCounterApplication;
import sk.app.domain.WordFilterService;
import sk.app.domain.api.WordCounter;
import sk.app.domain.api.WordFilter;
import sk.app.domain.api.outcoming.UserInterface;

public class JavaApplication {

	public static void main(String[] args) throws IOException {
		String fileName = null;

		if (args.length > 0) {
			fileName = args[0];
		}
		InputReaderFactory inputReaderFactory = new InputReaderFactory(fileName);

		WordFilter wordFilter = new WordFilterService(new FileWordResourceReader("stopwords.txt"));
		WordCounter wordCounter = new WordCounterApplication(wordFilter);

		UserInterface consoleUserInterface = new InputTextUserInterface(wordCounter, inputReaderFactory.createInputReader());

		consoleUserInterface.countWords();
	}
}
