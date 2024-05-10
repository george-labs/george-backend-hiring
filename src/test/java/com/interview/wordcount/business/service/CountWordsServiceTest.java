package com.interview.wordcount.business.service;

import com.interview.wordcount.business.port.outer.StopwordsSupplierPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CountWordsServiceTest {

	private final StopwordsSupplierPort stopwordsSupplierPort = new TestStopwordsSupplierAdapter();
	private final CountWordsService countWordsService = new CountWordsService(stopwordsSupplierPort);

	@Test
	public void thatEmptyInputCanBeCounted() {
		Assertions.assertEquals(0, countWordsService.count(null));
		Assertions.assertEquals(0, countWordsService.count(""));
	}

	@Test
	public void thatWordsCanBeCounted() {
		Assertions.assertEquals(1, countWordsService.count("asdf"));
		Assertions.assertEquals(1, countWordsService.count("  asdfA   "));
		Assertions.assertEquals(3, countWordsService.count("  asdfB sdfg  ghgds"));
		Assertions.assertEquals(2, countWordsService.count("  asdfB  ghgds"));
		Assertions.assertEquals(4, countWordsService.count("Mary had a little lamb"));
	}

	@Test
	public void thatWordsWithUnsupportedCharsAreNotCounted() {
		Assertions.assertEquals(1, countWordsService.count("asdf sdfg6"));
	}

	@Test
	public void thatStopwordsAreNotCounted() {
		Assertions.assertEquals(1, countWordsService.count("asdf the"));
	}

	class TestStopwordsSupplierAdapter implements StopwordsSupplierPort {

		@Override
		public List<String> getStopwords() {
			return List.of("a", "the");
		}
	}
}
