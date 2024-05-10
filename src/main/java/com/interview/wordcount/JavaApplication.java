package com.interview.wordcount;

import com.interview.wordcount.business.adapter.FileInputSupplierAdapter;
import com.interview.wordcount.business.adapter.FileStopwordsSupplierAdapter;
import com.interview.wordcount.business.adapter.TerminalInputSupplierAdapter;
import com.interview.wordcount.business.adapter.TerminalOutputAdapter;
import com.interview.wordcount.business.port.inner.CountWordsUseCase;
import com.interview.wordcount.business.port.outer.InputSupplierPort;
import com.interview.wordcount.business.service.CountWordsService;

public class JavaApplication {

	public static void main(String[] args) {
		InputSupplierPort inputSupplierPort = args.length == 0 ? new TerminalInputSupplierAdapter() : new FileInputSupplierAdapter(args[0]);
		CountWordsUseCase countWordsUseCase = new CountWordsService(new FileStopwordsSupplierAdapter());
		new TerminalOutputAdapter().write(countWordsUseCase.count(inputSupplierPort.getInputText()));
	}
}
