package com.interview.wordcount;

import com.interview.wordcount.business.adapter.FileStopwordsSupplierAdapter;
import com.interview.wordcount.business.adapter.TerminalOutputAdapter;
import com.interview.wordcount.business.port.inner.CountWordsUseCase;
import com.interview.wordcount.business.service.CountWordsService;

import java.util.Scanner;

public class JavaApplication {

	public static void main(String[] args) {
		Scanner cmdScanner = new Scanner(System.in);
		System.out.println("Enter text: ");
		String inputText = cmdScanner.nextLine();
		CountWordsUseCase countWordsUseCase = new CountWordsService(new FileStopwordsSupplierAdapter());
		new TerminalOutputAdapter().write(countWordsUseCase.count(inputText));
	}
}
