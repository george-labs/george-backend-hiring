package sk.app.adaptor.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import sk.app.application.port.outgoing.InputTextReader;

public class FileInputReader implements InputTextReader {

	private final String absolutePath;

	public FileInputReader(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	@Override
	public String readText() throws IOException {
			Path fileName = Path.of(absolutePath);
			return Files.readString(fileName);
	}
}
