package com.interview.wordcount.business.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FileStopwordsSupplierAdapterTest {

	private final FileStopwordsSupplierAdapter adapter = new FileStopwordsSupplierAdapter();

	@Test
	public void thatStopwordsCanBeReadFromFile() {
		List<String> stopwords = adapter.getStopwords();

		Assertions.assertNotNull(stopwords);
		Assertions.assertEquals(3, stopwords.size());
		Assertions.assertEquals(List.of("the", "a", "on"), stopwords);
	}
}
