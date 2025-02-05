import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class WordCounterTest {

	@Test
	public void testWhenOneUppercaseWordThenCountEquals1() {
		assertEquals(new WordsCountInfo(1, 1), WordCounter.getWordsCount("HELLO"));
	}

	@Test
	public void testWhenOneLowercaseWordThenCountEquals1() {
		assertEquals(new WordsCountInfo(1, 1), WordCounter.getWordsCount("hello"));
	}

	@Test
	public void testWhenOneMixedcaseWordThenCountEquals1() {
		assertEquals(new WordsCountInfo(1, 1), WordCounter.getWordsCount("Hello"));
	}

	@Test
	public void testWhenOneWordWithDigitThenCountEquals0() {
		assertEquals(new WordsCountInfo(0, 0), WordCounter.getWordsCount("He2o"));
	}

	@Test
	public void testWhenOneWordWithDollarThenCountEquals0() {
		assertEquals(new WordsCountInfo(0, 0), WordCounter.getWordsCount("He$o"));
	}

	@Test
	public void testWhenMoreWordsWithSpacesThenCountEqualsWordsCount() {
		assertEquals(new WordsCountInfo(4, 4), WordCounter.getWordsCount("Hello and hi world."));
	}

	@Test
	public void testWhenMixedAlloweAndNotAlloweWordsThenCountEqualsAllowedWordsCount() {
		assertEquals(new WordsCountInfo(3, 3), WordCounter.getWordsCount("Hello and hi5 world."));
	}

	@Test
	public void testWhenMoreWordsWithWhiteCharsThenCountEqualsWordsCount() {
		assertEquals(new WordsCountInfo(4, 4), WordCounter.getWordsCount("Hello\tand hi world."));
	}

	@Test
	public void testWhenStopwordThenCountEquals0() {
		assertEquals(new WordsCountInfo(0, 0), WordCounter.getWordsCount("the", Collections.singleton("the")));
	}

	@Test
	public void testWhenNonStopwordsAndStopwordsThenCountEqualsNonStopwords() {
		assertEquals(new WordsCountInfo(6, 6),
				WordCounter.getWordsCount("This is a test with the mixed words.", Set.of("the", "a")));
	}

	@Test
	public void testWhenTwoEqualWordsThenUniqueCountEquals1() {
		assertEquals(new WordsCountInfo(2, 1), WordCounter.getWordsCount("hello hello"));
	}

	@Test
	public void testWhenWordsHaveDotSeparatorThenWordsAreCounted() {
		assertEquals(new WordsCountInfo(5, 5), WordCounter.getWordsCount("I visited www.abc.com."));
	}

	@Test
	public void testWhenWordsHaveCommaSeparatorThenWordsAreCounted() {
		assertEquals(new WordsCountInfo(6, 6), WordCounter.getWordsCount("I saw cat, dog and mouse."));
	}

	@Test
	public void testWhenWordsHaveMixedSeparatorsThenWordsAreCounted() {
		assertEquals(new WordsCountInfo(7, 6),
				WordCounter.getWordsCount("I said: - \"Hi\". He said: - \"He-\nllo\""));
	}

	@Test
	public void testWhenWordContainsHyphenThenWordIsCountedAs1() {
		assertEquals(new WordsCountInfo(1, 1), WordCounter.getWordsCount("Humpty-Dumpty"));
	}
}
