import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {
	@Test
	void countWords_withoutStopwords() throws Exception {
		final WordCounter wordCounter = new WordCounter(new String[0]);

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
		final WordCounter wordCounter = new WordCounter(new String[] {"had", "a", "asdf"});

		Assertions.assertEquals(3, wordCounter.countWords("Mary had a little lamb"));
		// more than one space
		Assertions.assertEquals(3, wordCounter.countWords("Mary  had  a  little  lamb"));
		// trailing spaces
		Assertions.assertEquals(3, wordCounter.countWords("Mary  had  a  little  lamb  "));
		// leading and trailing spaces
		Assertions.assertEquals(3, wordCounter.countWords("  Mary  had  a  little  lamb  "));
		// a different separator than whitespace
		Assertions.assertEquals(0, wordCounter.countWords("asdf2asdf"));
	}
}
