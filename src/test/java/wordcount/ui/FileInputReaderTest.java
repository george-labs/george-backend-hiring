package wordcount.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileInputReaderTest {

	private static final String EXAMPLE_FILE_ON_CLASSPATH = "mytext.txt";
	private static final String NONEXISTENT_FILE = "nonexistent.txt";

	@Test
	void readUserInputWithExampleFileOnClasspath() {
		String expectedString = "Mary had a little lamb";
		FileInputReader fileInputReader = new FileInputReader();
		fileInputReader.setFileName(EXAMPLE_FILE_ON_CLASSPATH);

		String readString = fileInputReader.readUserInput();

		assertEquals(expectedString, readString);
	}

	@Test
	void readUserInputWithTempFile(@TempDir Path tempDir) throws IOException {
		String expectedString = "Mary had a little lamb";

		// create temp file with content
		Path file = tempDir.resolve("mytext.txt");
		List<String> lines = Arrays.asList("Mary had", "a little", "lamb");
		Files.write(file, lines);

		// act: read temp file
		FileInputReader fileInputReader = new FileInputReader();
		fileInputReader.setFileName(file.toString());
		String readString = fileInputReader.readUserInput();

		assertEquals(expectedString, readString);
	}

	
	@Test
	void readUserInputWithEmptyFile(@TempDir Path tempDir) throws IOException {
		String expectedString = "";

		// create temp file with no content
		Path file = tempDir.resolve("mytext.txt");
		Files.write(file, new ArrayList<>());

		// act: read temp file
		FileInputReader fileInputReader = new FileInputReader();
		fileInputReader.setFileName(file.toString());
		String readString = fileInputReader.readUserInput();

		assertEquals(expectedString, readString);
	}

	
	@Test
	void readUserInputWithNonexistentFile() throws IOException {
		String expectedString = "";

		// act: read temp file
		FileInputReader fileInputReader = new FileInputReader();
		fileInputReader.setFileName(NONEXISTENT_FILE);
		String readString = fileInputReader.readUserInput();

		assertEquals(expectedString, readString);
	}
	
	// TODO: test with binary file
}
