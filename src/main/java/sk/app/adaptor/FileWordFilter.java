package sk.app.adaptor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import sk.app.adaptor.exception.InvalidFileException;
import sk.app.api.WordFilter;

public class FileWordFilter implements WordFilter {

	private final String fileName;
	private final List<String> stopWords;

	public FileWordFilter(String fileName, sk.app.adaptor.api.WordReader wordReader) {
		this.fileName = fileName;
		this.stopWords = wordReader.readWords();
	}

	@Override
	public boolean isStopWord(String word) {
		return stopWords.stream().anyMatch(line -> line.equals(word));
	}

	public List<String> readFiles() {
		try (InputStream inputStream = FileWordFilter.class.getClassLoader().getResourceAsStream(fileName)) {
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
