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
	public static String getInput(final String[] args, final InputStream stream) throws Exception {
		if (args.length == 0) {
			System.out.print("Enter text: ");
			return new BufferedReader(new InputStreamReader(stream)).readLine();
		} else {
			final String filename = args[0];
			Logger.getLogger(JavaApplication.class.getName()).log(Level.FINER, "using file {0}", filename);
			return Files.readString(Path.of(filename));
		}
	}

	public static void main(final String[] args) throws Exception {
		final WordCounter wordCounter = new WordCounter(Files.readAllLines(Path.of("stopwords.txt")));

		final String input = getInput(args, System.in);
		final WordCounter.Result wordCounterResult = wordCounter.extractWords(input);
		System.out.printf("Number of words: %d, unique: %d; average word length: %.2f\n",
				wordCounterResult.words().size(), wordCounterResult.uniqueWords().size(), wordCounterResult.avg());
	}
}
