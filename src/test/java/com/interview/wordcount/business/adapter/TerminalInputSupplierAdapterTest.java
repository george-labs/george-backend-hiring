package com.interview.wordcount.business.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class TerminalInputSupplierAdapterTest {

	private final TerminalInputSupplierAdapter adapter = new TerminalInputSupplierAdapter();

	@Test
	public void thatInputCanBeReadFromTerminal() {
		String text = "Lorem ipsum";
		System.setIn(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)));

		String inputText = adapter.getInputText();

		Assertions.assertEquals(text, inputText);
	}
}
