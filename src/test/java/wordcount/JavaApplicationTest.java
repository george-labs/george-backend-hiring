package wordcount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * This class contains integration test
 */
class JavaApplicationTest {

	private static final String EXAMPLE_INPUT = "Mary had a little lamb";

	// input+output prompts from ConsoleUserInterface
	protected static final String INPUT_PROMPT = "Enter text: ";
	protected static final String OUTPUT_PROMPT = "Number of words: ";

	@Test
	void mainWithExampleConsoleInput() {
		// redirect stdin
		ByteArrayInputStream bais = new ByteArrayInputStream(EXAMPLE_INPUT.getBytes());
		System.setIn(bais);

		// redirect stdout
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		JavaApplication.main(null);

		assertEquals(INPUT_PROMPT + OUTPUT_PROMPT + 4 + System.lineSeparator(), outputStreamCaptor.toString());
	}

	
	@Test
	void mainWithExampleFileInput(@TempDir Path tempDir) throws IOException {
		// create temp file with content
		Path file = tempDir.resolve("mytext.txt");
		List<String> lines = Arrays.asList("Mary had", "a little", "lamb");
		Files.write(file, lines);

		String[] args = {file.toString()};		

		// redirect stdout
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		
		JavaApplication.main(args);

		assertEquals(OUTPUT_PROMPT + 4 + System.lineSeparator(), outputStreamCaptor.toString());
	}

}
