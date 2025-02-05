import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class JavaApplicationTest {

	@Test
	public void testWhenOneUppercaseWordThenCountEquals1() {
		assertEquals(new WordsCountInfo(1, 1), JavaApplication.getWordsCount("HELLO"));
	}

	@Test
	public void testWhenOneLowercaseWordThenCountEquals1() {
		assertEquals(new WordsCountInfo(1, 1), JavaApplication.getWordsCount("hello"));
	}

	@Test
	public void testWhenOneMixedcaseWordThenCountEquals1() {
		assertEquals(new WordsCountInfo(1, 1), JavaApplication.getWordsCount("Hello"));
	}

	@Test
	public void testWhenOneWordWithDigitThenCountEquals0() {
		assertEquals(new WordsCountInfo(0, 0), JavaApplication.getWordsCount("He2o"));
	}

	@Test
	public void testWhenOneWordWithDollarThenCountEquals0() {
		assertEquals(new WordsCountInfo(0, 0), JavaApplication.getWordsCount("He$o"));
	}

	@Test
	public void testWhenMoreWordsWithSpacesThenCountEqualsWordsCount() {
		assertEquals(new WordsCountInfo(4, 4), JavaApplication.getWordsCount("Hello and hi world."));
	}

	@Test
	public void testWhenMixedAlloweAndNotAlloweWordsThenCountEqualsAllowedWordsCount() {
		assertEquals(new WordsCountInfo(3, 3), JavaApplication.getWordsCount("Hello and hi5 world."));
	}

	@Test
	public void testWhenMoreWordsWithWhiteCharsThenCountEqualsWordsCount() {
		assertEquals(new WordsCountInfo(4, 4), JavaApplication.getWordsCount("Hello\tand hi world."));
	}

	@Test
	public void testWhenStopwordThenCountEquals0() {
		assertEquals(new WordsCountInfo(0, 0), JavaApplication.getWordsCount("the", Collections.singleton("the")));
	}

	@Test
	public void testWhenNonStopwordsAndStopwordsThenCountEqualsNonStopwords() {
		assertEquals(new WordsCountInfo(6, 6),
				JavaApplication.getWordsCount("This is a test with the mixed words.", Set.of("the", "a")));
	}

	@Test
	public void testWhenTwoEqualWordsThenUniqueCountEquals1() {
		assertEquals(new WordsCountInfo(2, 1), JavaApplication.getWordsCount("hello hello"));
	}

	@Test
	public void testWhenWordsHaveDotSeparatorThenWordsAreCounted() {
		assertEquals(new WordsCountInfo(5, 5), JavaApplication.getWordsCount("I visited www.abc.com."));
	}

	@Test
	public void testWhenWordsHaveCommaSeparatorThenWordsAreCounted() {
		assertEquals(new WordsCountInfo(6, 6), JavaApplication.getWordsCount("I saw cat, dog and mouse."));
	}

	@Test
	public void testWhenWordsHaveMixedSeparatorsThenWordsAreCounted() {
		assertEquals(new WordsCountInfo(7, 5),
				JavaApplication.getWordsCount("I said: - \"Hi\". He said: - \"He-\nllo\""));
	}
}
