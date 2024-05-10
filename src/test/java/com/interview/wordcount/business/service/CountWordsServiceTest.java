package com.interview.wordcount.business.service;

import com.interview.wordcount.business.port.outer.StopwordsSupplierPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CountWordsServiceTest {

	private final StopwordsSupplierPort stopwordsSupplierPort = new TestStopwordsSupplierAdapter();

	@Test
	public void thatEmptyInputCanBeCounted() {
		Assertions.assertEquals(0, new CountWordsService(stopwordsSupplierPort).count(null));
		Assertions.assertEquals(0, new CountWordsService(stopwordsSupplierPort).count(""));
	}

	@Test
	public void thatWordsCanBeCounted() {
		Assertions.assertEquals(1, new CountWordsService(stopwordsSupplierPort).count("asdf"));
		Assertions.assertEquals(1, new CountWordsService(stopwordsSupplierPort).count("  asdfA   "));
		Assertions.assertEquals(3, new CountWordsService(stopwordsSupplierPort).count("  asdfB sdfg  ghgds"));
		Assertions.assertEquals(2, new CountWordsService(stopwordsSupplierPort).count("  asdfB  ghgds"));
		Assertions.assertEquals(5, new CountWordsService(stopwordsSupplierPort).count("Mary had a little lamb"));
	}

	@Test
	public void thatWordsWithUnsupportedCharsAreNotCounted() {
		Assertions.assertEquals(1, new CountWordsService(stopwordsSupplierPort).count("asdf sdfg6"));
	}

	class TestStopwordsSupplierAdapter implements StopwordsSupplierPort {

		@Override
		public List<String> getStopwords() {
			return List.of("a", "the");
		}
	}
}
