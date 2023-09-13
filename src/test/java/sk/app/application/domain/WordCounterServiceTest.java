package sk.app.application.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import sk.app.application.ListWordReader;
import sk.app.application.port.incoming.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterServiceTest {

	@Test
	public void testWordCounter() {
		WordCounter wordCounter = new WordCounterService(new WordFilterService(new ListWordReader()));

		assertEquals(2, wordCounter.countWords("hello world"));
		assertEquals(1, wordCounter.countWords("word"));
		assertEquals(2, wordCounter.countWords("word word"));
		assertEquals(3, wordCounter.countWords("      word        word       word    "));
		assertEquals(0, wordCounter.countWords(""));
		assertEquals(0, wordCounter.countWords("wor3d"));
		assertEquals(1, wordCounter.countWords("word wo$$d"));
		assertEquals(2, wordCounter.countWords("word? word. word"));
		assertEquals(2, wordCounter.countWords("hello-world"));
		assertEquals(2, wordCounter.countWords("some text."));
	}

	@Test
	public void testWordCounterFilter() {
		WordFilterService wordFilter = new WordFilterService(new ListWordReader(List.of("the", "a", "on", "off")));

		WordCounter wordCounter = new WordCounterService(wordFilter);

		assertEquals(4, wordCounter.countWords("Mary had a little lamb"));
	}

}
