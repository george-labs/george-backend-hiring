import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class WordCounterTest {

	@Test
	public void testWhenOneUppercaseWordThenCountEquals1() {
		assertEquals(new WordsCountInfo(1, 1, 5), WordCounter.getWordsCount("HELLO"));
	}

	@Test
	public void testWhenOneLowercaseWordThenCountEquals1() {
		assertEquals(new WordsCountInfo(1, 1, 5), WordCounter.getWordsCount("hello"));
	}

	@Test
	public void testWhenOneMixedcaseWordThenCountEquals1() {
		assertEquals(new WordsCountInfo(1, 1, 5), WordCounter.getWordsCount("Hello"));
	}

	@Test
	public void testWhenOneWordWithDigitThenCountEquals0() {
		assertEquals(new WordsCountInfo(0, 0, 0), WordCounter.getWordsCount("He2o"));
	}

	@Test
	public void testWhenOneWordWithDollarThenCountEquals0() {
		assertEquals(new WordsCountInfo(0, 0, 0), WordCounter.getWordsCount("He$o"));
	}

	@Test
	public void testWhenMoreWordsWithSpacesThenCountEqualsWordsCount() {
		WordsCountInfo actual = WordCounter.getWordsCount("Hello and hi world.");
		assertEquals(4, actual.wordsCount());
		assertEquals(4, actual.uniqueWordsCount());
	}

	@Test
	public void testWhenMixedAlloweAndNotAlloweWordsThenCountEqualsAllowedWordsCount() {
		WordsCountInfo actual = WordCounter.getWordsCount("Hello and hi5 world.");
		assertEquals(3, actual.wordsCount());
		assertEquals(3, actual.uniqueWordsCount());
	}

	@Test
	public void testWhenMoreWordsWithWhiteCharsThenCountEqualsWordsCount() {
		WordsCountInfo actual = WordCounter.getWordsCount("Hello\tand hi world.");
		assertEquals(4, actual.wordsCount());
		assertEquals(4, actual.uniqueWordsCount());
	}

	@Test
	public void testWhenStopwordThenCountEquals0() {
		assertEquals(new WordsCountInfo(0, 0, 0), WordCounter.getWordsCount("the", Collections.singleton("the")));
	}

	@Test
	public void testWhenNonStopwordsAndStopwordsThenCountEqualsNonStopwords() {
		WordsCountInfo actual = WordCounter.getWordsCount("This is a test with the mixed words.", Set.of("the", "a"));
		assertEquals(6, actual.wordsCount());
		assertEquals(6, actual.uniqueWordsCount());
	}

	@Test
	public void testWhenTwoEqualWordsThenUniqueCountEquals1() {
		WordsCountInfo actual = WordCounter.getWordsCount("hello hello");
		assertEquals(2, actual.wordsCount());
		assertEquals(1, actual.uniqueWordsCount());
	}

	@Test
	public void testWhenWordsHaveDotSeparatorThenWordsAreCounted() {
		WordsCountInfo actual = WordCounter.getWordsCount("I visited www.abc.com.");
		assertEquals(5, actual.wordsCount());
		assertEquals(5, actual.uniqueWordsCount());
	}

	@Test
	public void testWhenWordsHaveCommaSeparatorThenWordsAreCounted() {
		WordsCountInfo actual = WordCounter.getWordsCount("I saw cat, dog and mouse.");
		assertEquals(6, actual.wordsCount());
		assertEquals(6, actual.uniqueWordsCount());
	}

	@Test
	public void testWhenWordsHaveMixedSeparatorsThenWordsAreCounted() {
		WordsCountInfo actual = WordCounter.getWordsCount("I said: - \"Hi\". He said: - \"He-\nllo\"");
		assertEquals(7, actual.wordsCount());
		assertEquals(6, actual.uniqueWordsCount());
	}

	@Test
	public void testWhenWordContainsHyphenThenWordIsCountedAs1() {
		WordsCountInfo actual = WordCounter.getWordsCount("Humpty-Dumpty");
		assertEquals(1, actual.wordsCount());
		assertEquals(1, actual.uniqueWordsCount());
	}

	@Test
	public void testWhenOneWordThenAvgIsDefinedByWord() {
		WordsCountInfo actual = WordCounter.getWordsCount("Hello");
		assertEquals(5, actual.averageWordLength());
	}

	@Test
	public void testWhenTwoWordsOfSameLengthThenAvgIsDefinedByWord() {
		WordsCountInfo actual = WordCounter.getWordsCount("Hello world");
		assertEquals(5, actual.averageWordLength());
	}

	@Test
	public void testWhenTwoWordsOfDifferentLengthThenAvgIsDefinedByBothWords() {
		WordsCountInfo actual = WordCounter.getWordsCount("Hello Adam");
		assertEquals(((double) 5 + 4) / 2, actual.averageWordLength());
	}

	@Test
	public void testWhenNoWordsThenCountsAndAvgIs0() {
		assertEquals(new WordsCountInfo(0, 0, 0), WordCounter.getWordsCount(""));
	}
}
