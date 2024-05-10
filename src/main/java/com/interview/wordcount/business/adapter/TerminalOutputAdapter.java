package com.interview.wordcount.business.adapter;

import com.interview.wordcount.business.port.outer.OutputPort;
import com.interview.wordcount.data.AnalyzedData;

public class TerminalOutputAdapter implements OutputPort {
	@Override
	public void write(AnalyzedData data) {
		System.out.println("Number of words: " + data.wordCount() + ", unique: " + data.uniqueWordCount());
	}
}
