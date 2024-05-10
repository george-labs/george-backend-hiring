package com.interview.wordcount.business.adapter;

import com.interview.wordcount.business.port.outer.InputSupplierPort;

import java.util.Scanner;

public class TerminalInputSupplierAdapter implements InputSupplierPort {
	@Override
	public String getInputText() {
		Scanner cmdScanner = new Scanner(System.in);
		System.out.println("Enter text: ");
		return cmdScanner.nextLine();
	}
}
