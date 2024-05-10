package com.interview.wordcount.business.service;

import com.interview.wordcount.business.port.inner.CountWordsUseCase;

import java.util.Arrays;

public class CountWordsService implements CountWordsUseCase {
	@Override
	public long count(String text) {
		String[] words = (text == null) ? new String[0] : text.split("\\s+");
		return Arrays.stream(words).filter(word -> word.matches("^[a-zA-Z]+$")).count();
	}
}
