import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {
	@Test
	void countWords() {
		final WordCounter wordCounter = new WordCounter();

		Assertions.assertEquals(5, wordCounter.countWords("Mary had a little lamb"));
		// more than one space
		Assertions.assertEquals(5, wordCounter.countWords("Mary  had  a  little  lamb"));
		// trailing spaces
		Assertions.assertEquals(5, wordCounter.countWords("Mary  had  a  little  lamb  "));
		// leading and trailing spaces
		Assertions.assertEquals(5, wordCounter.countWords("  Mary  had  a  little  lamb  "));
		// a different separator than whitespace
		Assertions.assertEquals(2, wordCounter.countWords("asef2asdf"));
	}
}
