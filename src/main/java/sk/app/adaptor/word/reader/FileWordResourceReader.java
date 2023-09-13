package sk.app.adaptor.word.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import sk.app.application.port.outgoing.WordReader;
import sk.app.adaptor.exception.InvalidFileException;

public class FileWordResourceReader implements WordReader {

	private final String fileName;

	public FileWordResourceReader(String fileName) {
		this.fileName = fileName;
	}

	public List<String> readWords() {
		try (InputStream inputStream = FileWordResourceReader.class.getClassLoader().getResourceAsStream(fileName)) {
			if (inputStream == null) {
				throw new FileNotFoundException(String.format("Cannot find file: %s", fileName));
			}
			try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
				 BufferedReader reader = new BufferedReader(streamReader)) {
				return reader.lines().collect(Collectors.toList());
			}
		} catch (IOException e) {
			throw new InvalidFileException(e);
		}
	}
}
