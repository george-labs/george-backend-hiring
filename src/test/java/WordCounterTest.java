import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {
	@Test
	void countWords_withoutStopwords() throws Exception {
		final WordCounter wordCounter = new WordCounter(new ArrayList<String>());

		Assertions.assertEquals(5, wordCounter.countWords("Mary had a little lamb"));
		// more than one space
		Assertions.assertEquals(5, wordCounter.countWords("Mary  had  a  little  lamb"));
		// trailing spaces
		Assertions.assertEquals(5, wordCounter.countWords("Mary  had  a  little  lamb  "));
		// leading and trailing spaces
		Assertions.assertEquals(5, wordCounter.countWords("  Mary  had  a  little  lamb  "));
		// a different separator than whitespace
		Assertions.assertEquals(2, wordCounter.countWords("asdf2asdf"));
	}

	@Test
	void countWords_withStopwords() throws Exception {
		final WordCounter wordCounter = new WordCounter(Arrays.asList("had", "a", "asdf"));

		Assertions.assertEquals(3, wordCounter.countWords("Mary had a little lamb"));
		// a different separator than whitespace
		Assertions.assertEquals(0, wordCounter.countWords("asdf2asdf"));
	}

	@Test
	void extractWords_withStopwords() throws Exception {
		final WordCounter wordCounter = new WordCounter(Arrays.asList("the", "a", "on", "off"));

		final List<String> words = wordCounter.extractWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
		final Set<String> uniqueWords = new HashSet<String>(words);
		Assertions.assertEquals(9, words.size());
		Assertions.assertEquals(7, uniqueWords.size());
	}
}
