package com.interview.wordcount.business.adapter;

import com.interview.wordcount.business.port.outer.StopwordsSupplierPort;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileStopwordsSupplierAdapter implements StopwordsSupplierPort {
	@Override
	public List<String> getStopwords() {
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource("stopwords.txt").toURI());
			return readLines(path);
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException("Exception occured during reading stopwords.txt", e);
		}
	}

	@NotNull
	private static List<String> readLines(Path path) throws IOException {
		try (Stream<String> lines = Files.lines(path)) {
			return lines.toList();
		}
	}
}
