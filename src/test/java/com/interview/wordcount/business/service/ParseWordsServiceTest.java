package com.interview.wordcount.business.service;

import com.interview.wordcount.business.port.outer.StopwordsSupplierPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParseWordsServiceTest {

	private final StopwordsSupplierPort stopwordsSupplierPort = new TestStopwordsSupplierAdapter();
	private final ParseWordsService parseWordsService = new ParseWordsService(stopwordsSupplierPort);

	@Test
	public void thatEmptyInputCanBeCounted() {
		Assertions.assertEquals(List.of(), parseWordsService.parse(null));
		Assertions.assertEquals(List.of(), parseWordsService.parse(""));
	}

	@Test
	public void thatWordsCanBeCounted() {
		Assertions.assertEquals(List.of("asdf"), parseWordsService.parse("asdf"));
		Assertions.assertEquals(List.of("asdfA"), parseWordsService.parse("  asdfA   "));
		Assertions.assertEquals(List.of("asdfB", "sdfg", "ghgds"), parseWordsService.parse("  asdfB sdfg  ghgds"));
		Assertions.assertEquals(List.of("asdfB", "ghgds"), parseWordsService.parse("  asdfB  ghgds"));
		Assertions.assertEquals(List.of("Mary", "had", "little", "lamb"), parseWordsService.parse("Mary had a little lamb"));
	}

	@Test
	public void thatWordsWithUnsupportedCharsAreNotCounted() {
		Assertions.assertEquals(List.of("asdf"), parseWordsService.parse("asdf sdfg6"));
	}

	@Test
	public void thatStopwordsAreNotCounted() {
		Assertions.assertEquals(List.of("asdf"), parseWordsService.parse("asdf the"));
	}

	static class TestStopwordsSupplierAdapter implements StopwordsSupplierPort {

		@Override
		public List<String> getStopwords() {
			return List.of("a", "the");
		}
	}
}
