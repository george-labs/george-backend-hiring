package com.interview.wordcount.business.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileInputSupplierAdapterTest {

	@Test
	public void thatInputCanBeReadFromFile() {
		String inputFilePath = getClass().getClassLoader().getResource("input.txt").getFile().replaceAll("^/", "");

		FileInputSupplierAdapter adapter = new FileInputSupplierAdapter(inputFilePath);

		Assertions.assertEquals("Lorem ipsum dolor", adapter.getInputText());
	}

	@Test
	public void thatReadingFromNonExistingFileThrowsException() {
		String inputFilePath = "none";
		FileInputSupplierAdapter adapter = new FileInputSupplierAdapter(inputFilePath);

		RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, adapter::getInputText);
		Assertions.assertEquals("Exception thrown while trying to read input from file " + inputFilePath, runtimeException.getMessage());
	}
}
