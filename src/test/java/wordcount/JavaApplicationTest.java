package wordcount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import wordcount.JavaApplication;
import wordcount.ui.ConsoleUserInterface;
import wordcount.ui.UserInterface;

/**
 * This class contains integration test
 */
class JavaApplicationTest {

	private static final String EXAMPLE_INPUT = "Mary had a little lamb";

	// input+output prompts from ConsoleUserInterface
	protected static final String INPUT_PROMPT = "Enter text: ";
	protected static final String OUTPUT_PROMPT = "Number of words: ";

	@Test
	void mainWithExampleInput() {
		// redirect stdin
		ByteArrayInputStream bais = new ByteArrayInputStream(EXAMPLE_INPUT.getBytes());
		System.setIn(bais);

		// redirect stdout
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		JavaApplication.main(null);

		assertEquals(INPUT_PROMPT + OUTPUT_PROMPT + 4 + System.lineSeparator(), outputStreamCaptor.toString());
	}

}
