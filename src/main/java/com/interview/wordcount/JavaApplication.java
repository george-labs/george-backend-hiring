package com.interview.wordcount;

import com.interview.wordcount.business.port.in.CountWordsUseCase;
import com.interview.wordcount.business.service.CountWordsService;

import java.util.Scanner;

public class JavaApplication {

	public static void main(String[] args) {
		Scanner cmdScanner = new Scanner(System.in);
		System.out.println("Enter text: ");
		String inputText = cmdScanner.nextLine();
		CountWordsUseCase countWordsUseCase = new CountWordsService();
		System.out.println("Number of words: " + countWordsUseCase.count(inputText));
	}
}
