package com.interview.wordcount.business.adapter;

import com.interview.wordcount.business.port.outer.OutputPort;

public class TerminalOutputAdapter implements OutputPort {
	@Override
	public void write(long count) {
		System.out.println("Number of words: " + count);
	}
}
