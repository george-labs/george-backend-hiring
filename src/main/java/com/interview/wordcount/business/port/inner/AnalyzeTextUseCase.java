package com.interview.wordcount.business.port.inner;

import com.interview.wordcount.data.AnalyzedData;

public interface AnalyzeTextUseCase {

	AnalyzedData analyze(String text);
}
