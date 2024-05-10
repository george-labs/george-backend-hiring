package com.interview.wordcount.business.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountWordsServiceTest {

	@Test
	public void thatEmptyInputCanBeCounted() {
		Assertions.assertEquals(0, new CountWordsService().count(null));
		Assertions.assertEquals(0, new CountWordsService().count(""));
	}

	@Test
	public void thatWordsCanBeCounted() {
		Assertions.assertEquals(1, new CountWordsService().count("asdf"));
		Assertions.assertEquals(1, new CountWordsService().count("  asdfA   "));
		Assertions.assertEquals(3, new CountWordsService().count("  asdfB sdfg  ghgds"));
		Assertions.assertEquals(2, new CountWordsService().count("  asdfB  ghgds"));
		Assertions.assertEquals(5, new CountWordsService().count("Mary had a little lamb"));
	}

	@Test
	public void thatWordsWithUnsupportedCharsAreNotCounted() {
		Assertions.assertEquals(1, new CountWordsService().count("asdf sdfg6"));
	}
}
