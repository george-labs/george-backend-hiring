package com.interview.wordcount.business.service;

import com.interview.wordcount.business.port.inner.AnalyzeTextUseCase;
import com.interview.wordcount.business.port.inner.CountWordsUseCase;
import com.interview.wordcount.business.port.inner.ParseWordsUseCase;
import com.interview.wordcount.data.AnalyzedData;

import java.util.List;
import java.util.stream.Collectors;

public class AnalyzeTextService implements AnalyzeTextUseCase {

	private final ParseWordsUseCase parseWordsUseCase;
	private final CountWordsUseCase countWordsUseCase;

	public AnalyzeTextService(ParseWordsUseCase parseWordsUseCase, CountWordsUseCase countWordsUseCase) {
		this.parseWordsUseCase = parseWordsUseCase;
		this.countWordsUseCase = countWordsUseCase;
	}

	@Override
	public AnalyzedData analyze(String text) {
		List<String> words = parseWordsUseCase.parse(text);
		return new AnalyzedData(countWordsUseCase.count(words), countWordsUseCase.count(words.stream().collect(Collectors.toSet())));
	}
}
