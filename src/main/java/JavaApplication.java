import java.io.IOException;

import sk.app.adaptor.input.InputReaderFactory;
import sk.app.adaptor.ui.InputTextUserInterface;
import sk.app.adaptor.ui.UserInterface;
import sk.app.adaptor.word.reader.FileWordResourceReader;
import sk.app.application.api.WordFilter;
import sk.app.application.domain.UniqueWordCounterService;
import sk.app.application.domain.WordCalculationService;
import sk.app.application.domain.WordCounterService;
import sk.app.application.domain.WordFilterService;
import sk.app.application.port.incoming.WordCounter;

public class JavaApplication {

	public static void main(String[] args) throws IOException {
		String fileName = null;

		if (args.length > 0) {
			fileName = args[0];
		}
		InputReaderFactory inputReaderFactory = new InputReaderFactory(fileName);

		WordFilter wordFilter = new WordFilterService(new FileWordResourceReader("stopwords.txt"));
		WordCounter wordCounter = new WordCounterService(wordFilter);
		WordCounter uniqueWordCounter = new UniqueWordCounterService(wordFilter);

		UserInterface ui = new InputTextUserInterface(wordCounter, uniqueWordCounter,
				new WordCalculationService(new WordCounterService(wordFilter)),
				inputReaderFactory.createInputReader());

		ui.countWords();
	}
}
