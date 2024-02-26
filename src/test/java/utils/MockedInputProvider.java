package utils;

import wordcount.input.InputProvider;

public class MockedInputProvider implements InputProvider {
	
	private String input;
	
	public MockedInputProvider(String input) {
		this.input = input;
	}

	@Override
	public String getInput() {
		return this.input;
	}

}
