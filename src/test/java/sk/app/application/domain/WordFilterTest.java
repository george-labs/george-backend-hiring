package sk.app.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import sk.app.ListWordReader;
import sk.app.application.domain.WordFilterService;
import sk.app.application.api.WordFilter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordFilterTest {

	@Test
	public void testWordFilter() {
		WordFilter wordFilter = new WordFilterService(new ListWordReader(List.of("a")));

		assertTrue(wordFilter.isStopWord("a"));
		assertFalse(wordFilter.isStopWord("b"));
	}

}
