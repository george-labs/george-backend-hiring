package sk.app.adaptor.input;

import sk.app.application.port.outgoing.InputTextReader;

public class InputReaderFactory {

	private final String fileName;

	public InputReaderFactory(String fileName) {
		this.fileName = fileName;
	}

	public InputTextReader createInputReader() {
		if (fileName == null || fileName.isBlank()) {
			return new ConsoleInputReader();
		}
		return new FileInputReader(fileName);
	}
}
