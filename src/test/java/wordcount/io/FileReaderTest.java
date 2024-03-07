package wordcount.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class FileReaderTest {
	
	private static final String EXAMPLE_FILE = "stopwords.txt";
	private static final String EMPTY_FILE = "empty.txt";
	private static final String DUPLICATES_FILE = "duplicates.txt";
	private static final String INVALID_FILE = "invalid.txt";
	
	@Test
	void readLinesWithEmptyFile() {
		List<String> expecetedList = new ArrayList<>();
		List<String> lines = FileReader.readLines(EMPTY_FILE);
		assertEquals(expecetedList, lines);		
	}

	@Test
	void readLinesWithInvalidFile() {
		List<String> expecetedList = new ArrayList<>();
		List<String> lines = FileReader.readLines(INVALID_FILE);
		assertEquals(expecetedList, lines);		
	}

	
	@Test
	void readLinesWithExampleFile() {
		String[] expectedArray = {"the","a","on","off"};
		List<String> expecetedList = new ArrayList<>(Arrays.asList(expectedArray));
		
		List<String> lines = FileReader.readLines(EXAMPLE_FILE);
		
		assertEquals(expecetedList, lines);		
	}

	
	@Test
	void readLinesWithDuplicatesFile() {
		String[] expectedArray = {"lamb","a","lamb","on","off"};
		List<String> expecetedList = new ArrayList<>(Arrays.asList(expectedArray));
		
		List<String> lines = FileReader.readLines(DUPLICATES_FILE);
		
		assertEquals(expecetedList, lines);		
	}

	
	@Test
	void readUniqueLinesWithDuplicatesFile() {
		String[] expectedArray = {"lamb","a","on","off"};
		Set<String> expectedSet = new HashSet<>(Arrays.asList(expectedArray));
		
		Set<String> lines = FileReader.readUniqueLines(DUPLICATES_FILE);
		
		assertEquals(expectedSet, lines);		
	}
	
}
