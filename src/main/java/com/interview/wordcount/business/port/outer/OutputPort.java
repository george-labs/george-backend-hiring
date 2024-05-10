package com.interview.wordcount.business.port.outer;

import com.interview.wordcount.data.AnalyzedData;

public interface OutputPort {

	void write(AnalyzedData data);
}
