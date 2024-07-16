import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication {
	public static void main(final String[] args) throws Exception {
		final WordCounter wordCounter = new WordCounter(Files.readAllLines(Path.of("stopwords.txt")));

		final String input;
		if (args.length == 0) {
			// read a line and count the number of words inside
			System.out.print("Enter text: ");
			input = System.console().readLine();
		} else {
			final String filename = args[0];
			Logger.getLogger(JavaApplication.class.getName()).log(Level.FINER, "using file {0}", filename);
			input = Files.readString(Path.of(filename));
		}
		System.out.printf("Number of words: %d\n", wordCounter.countWords(input));
	}
}
