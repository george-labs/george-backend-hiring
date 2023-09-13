package sk.app;

import org.junit.jupiter.api.Test;

import sk.app.api.WordCounter;
import sk.app.domain.WordCounterApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterApplicationTest {

	@Test
	public void testWordCounter() {
		WordCounter wordCounter = new WordCounterApplication();

		assertEquals(2, wordCounter.countWords("hello world"));
		assertEquals(1, wordCounter.countWords("word"));
		assertEquals(2, wordCounter.countWords("word word"));
		assertEquals(3, wordCounter.countWords("      word        word       word    "));
		assertEquals(0, wordCounter.countWords(""));
		assertEquals(0, wordCounter.countWords("wor3d"));
		assertEquals(1, wordCounter.countWords("word wo$$d"));
		assertEquals(1, wordCounter.countWords("word? word. word"));
	}
}
