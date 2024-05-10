package com.interview.wordcount.business.adapter;

import com.interview.wordcount.business.port.outer.StopwordsSupplierPort;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileStopwordsSupplierAdapter implements StopwordsSupplierPort {
	@Override
	public List<String> getStopwords() {
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource("stopwords.txt").toURI());
			return Files.lines(path).toList();
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
