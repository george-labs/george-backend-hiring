package sk.app.application.domain;

import org.junit.jupiter.api.Test;

import sk.app.application.ListWordReader;
import sk.app.application.port.incoming.WordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueWordCounterServiceTest {

	@Test
	public void testWordCounter() {
		WordCounter wordCounter = new UniqueWordCounterService(new WordFilterService(new ListWordReader())); // no word filter

		assertEquals(9, wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."));
	}


}
