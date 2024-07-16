import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication {
	// recommended improvement if the next data source is required:
	// the input should be provided by an instance of a new interface JavaApplication.Reader
	public static String getInput(final CLIParser cli, final InputStream stream) throws Exception {
		if (cli.isInputReadFromStdin()) {
			System.out.print("Enter text: ");
			return new BufferedReader(new InputStreamReader(stream)).readLine();
		} else if (cli.isInputReadFromFile()) {
			Logger.getLogger(JavaApplication.class.getName()).log(Level.FINER, "using file {0}", cli.filename());
			return Files.readString(Path.of(cli.filename()));
		} else {
			throw new IllegalArgumentException("unknown command line arguments");
		}
	}

	public static void main(final String[] args) throws Exception {
		final WordCounter wordCounter = new WordCounter(Files.readAllLines(Path.of("stopwords.txt")));

		final CLIParser cli = new CLIParser(args);
		final String input = getInput(cli, System.in);
		final WordCounter.Result wordCounterResult = wordCounter.extractWords(input);
		System.out.printf("Number of words: %d, unique: %d; average word length: %.2f\n",
				wordCounterResult.words().size(), wordCounterResult.uniqueWords().size(), wordCounterResult.avg());
		if (cli.isIndexDesired()) {
			System.out.println("Index:");
			wordCounterResult.uniqueWords().forEach(word -> System.out.println(word));
		}
	}
}
