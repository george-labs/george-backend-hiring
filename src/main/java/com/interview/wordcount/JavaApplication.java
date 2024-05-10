package com.interview.wordcount;

import com.interview.wordcount.business.adapter.FileInputSupplierAdapter;
import com.interview.wordcount.business.adapter.FileStopwordsSupplierAdapter;
import com.interview.wordcount.business.adapter.TerminalInputSupplierAdapter;
import com.interview.wordcount.business.adapter.TerminalOutputAdapter;
import com.interview.wordcount.business.port.inner.CountWordsUseCase;
import com.interview.wordcount.business.port.inner.ParseWordsUseCase;
import com.interview.wordcount.business.port.outer.InputSupplierPort;
import com.interview.wordcount.business.service.AnalyzeTextService;
import com.interview.wordcount.business.service.CountWordsService;
import com.interview.wordcount.business.service.ParseWordsService;

public class JavaApplication {

	public static void main(String[] args) {
		InputSupplierPort inputSupplierPort = args.length == 0 ? new TerminalInputSupplierAdapter() : new FileInputSupplierAdapter(args[0]);
		ParseWordsUseCase parseWordsUseCase = new ParseWordsService(new FileStopwordsSupplierAdapter());
		CountWordsUseCase countWordsUseCase = new CountWordsService();
		AnalyzeTextService analyzeTextService = new AnalyzeTextService(parseWordsUseCase, countWordsUseCase);
		new TerminalOutputAdapter().write(analyzeTextService.analyze(inputSupplierPort.getInputText()));
	}
}
