package com.interview.wordcount.business.service;

import com.interview.wordcount.business.port.inner.CountWordsUseCase;
import com.interview.wordcount.business.port.outer.StopwordsSupplierPort;

import java.util.Arrays;

public class CountWordsService implements CountWordsUseCase {

	private StopwordsSupplierPort stopwordsSupplierPort;

	public CountWordsService(StopwordsSupplierPort stopwordsSupplierPort) {
		this.stopwordsSupplierPort = stopwordsSupplierPort;
	}

	@Override
	public long count(String text) {
		String[] words = (text == null) ? new String[0] : text.split("\\s+");
		return Arrays.stream(words)
				.filter(word -> word.matches("^[a-zA-Z]+$"))
				.filter(word -> !stopwordsSupplierPort.getStopwords().contains(word))
				.count();
	}
}
