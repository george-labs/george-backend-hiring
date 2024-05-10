package com.interview.wordcount.business.service;

import com.interview.wordcount.business.port.inner.CountWordsUseCase;
import com.interview.wordcount.business.port.inner.ParseWordsUseCase;
import com.interview.wordcount.data.AnalyzedData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

public class AnalyzeTextServiceTest {

	private final AnalyzeTextService service = new AnalyzeTextService(new TestParseWordsService(), new TestCountWordsService());

	@Test
	public void thatTextCanBeAnalyzed() {
		Assertions.assertEquals(new AnalyzedData(3, 2), service.analyze("text"));
	}

	static class TestParseWordsService implements ParseWordsUseCase {

		@Override
		public List<String> parse(String text) {
			return List.of("word1", "word2", "word1");
		}
	}

	static class TestCountWordsService implements CountWordsUseCase {

		@Override
		public long count(Collection<String> words) {
			return words.size();
		}
	}
}
