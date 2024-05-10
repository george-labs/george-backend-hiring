package com.interview.wordcount.business.service;

import com.interview.wordcount.business.port.inner.ParseWordsUseCase;
import com.interview.wordcount.business.port.outer.StopwordsSupplierPort;

import java.util.Arrays;
import java.util.List;

public class ParseWordsService implements ParseWordsUseCase {

	private StopwordsSupplierPort stopwordsSupplierPort;

	public ParseWordsService(StopwordsSupplierPort stopwordsSupplierPort) {
		this.stopwordsSupplierPort = stopwordsSupplierPort;
	}
	@Override
	public List<String> parse(String text) {
		String[] words = (text == null) ? new String[0] : text.split("\\s+");
		return Arrays.stream(words)
				.filter(word -> word.matches("^[a-zA-Z]+$"))
				.filter(word -> !stopwordsSupplierPort.getStopwords().contains(word))
				.toList();
	}
}
