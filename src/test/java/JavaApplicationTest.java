import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * This class contains integration test
 */
class JavaApplicationTest {

	private static final String EXAMPLE_INPUT = "Mary had a little lamb";

	@Test
	void mainWithExampleInput() {
		// redirect stdin
		ByteArrayInputStream bais = new ByteArrayInputStream(EXAMPLE_INPUT.getBytes());
		System.setIn(bais);

		// redirect stdout
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		JavaApplication.main(null);

		assertEquals(JavaApplication.INPUT_PROMPT + JavaApplication.OUTPUT_PROMPT + 5 + System.lineSeparator(),
				outputStreamCaptor.toString());
	}

}
