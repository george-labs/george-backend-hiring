package com.interview.wordcount.business.service;

import com.interview.wordcount.business.port.inner.CountWordsUseCase;

import java.util.Collection;

public class CountWordsService implements CountWordsUseCase {

	public CountWordsService() {
	}

	@Override
	public long count(Collection<String> words) {
		return words.size();
	}
}
