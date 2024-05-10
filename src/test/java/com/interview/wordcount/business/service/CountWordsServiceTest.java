package com.interview.wordcount.business.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CountWordsServiceTest {

	private final CountWordsService countWordsService = new CountWordsService();

	@Test
	public void thatWordsCanBeCounted() {
		Assertions.assertEquals(0, countWordsService.count(List.of()));
		Assertions.assertEquals(5, countWordsService.count(List.of("Mary", "had", "a",  "little",  "lamb")));
	}
}
