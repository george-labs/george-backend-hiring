import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CLIParserTest {
	@Test
	void withoutArgs() {
		final CLIParser cli = new CLIParser();
		Assertions.assertFalse(cli.isIndexDesired());
		Assertions.assertFalse(cli.isInputReadFromFile());
		Assertions.assertTrue(cli.isInputReadFromStdin());
	}

	@Test
	void withIndex() {
		final CLIParser cli = new CLIParser("-index");
		Assertions.assertTrue(cli.isIndexDesired());
		Assertions.assertFalse(cli.isInputReadFromFile());
		Assertions.assertTrue(cli.isInputReadFromStdin());
	}

	@Test
	void withFilename() {
		final CLIParser cli = new CLIParser("filename.txt");
		Assertions.assertFalse(cli.isIndexDesired());
		Assertions.assertTrue(cli.isInputReadFromFile());
		Assertions.assertFalse(cli.isInputReadFromStdin());
	}

	@Test
	void withIndexAndFilename() {
		final CLIParser cli = new CLIParser("-index", "filename.txt");
		Assertions.assertTrue(cli.isIndexDesired());
		Assertions.assertTrue(cli.isInputReadFromFile());
		Assertions.assertFalse(cli.isInputReadFromStdin());
	}
}
