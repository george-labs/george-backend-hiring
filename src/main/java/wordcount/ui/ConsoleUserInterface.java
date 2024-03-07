package wordcount.ui;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

	protected static final String INPUT_PROMPT = "Enter text: ";
	protected static final String OUTPUT_PROMPT = "Number of words: ";

	@Override
	public String readUserInput() {
		// 1. prompt
		System.out.print(INPUT_PROMPT);
		// 2. read input
		// TODO separate class for input reader
		String line;
		try (Scanner scanner = new Scanner(System.in)) {
			line = scanner.nextLine();
		}
		return line;
	}

	@Override
	public void presentOutput(long output) {
		System.out.println(OUTPUT_PROMPT + output);
	}

}
