package wordcount.ui;

import java.util.Scanner;

public class ConsoleReader implements UserInputReader {
	protected static final String INPUT_PROMPT = "Enter text: ";

	// TODO define output stream in constructor instead of hardcoding System.out
	
	@Override
	public String readUserInput() {
		// 1. prompt
		System.out.print(INPUT_PROMPT);
		// 2. read input
		String line;
		try (Scanner scanner = new Scanner(System.in)) {
			line = scanner.nextLine();
		}
		return line;
	}
}
