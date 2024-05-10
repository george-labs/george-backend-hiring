package com.interview.wordcount.business.adapter;

import com.interview.wordcount.business.port.outer.InputSupplierPort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileInputSupplierAdapter implements InputSupplierPort {

	private final String inputFilePath;

	public FileInputSupplierAdapter(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}

	@Override
	public String getInputText() {
		Path path = Paths.get(inputFilePath);
		try (Stream<String> lines = Files.lines(path)) {
			String data = lines.collect(Collectors.joining("\n"));
			lines.close();
			return data;
		} catch (IOException e) {
			throw new RuntimeException("Exception thrown while trying to read input from file " + inputFilePath, e);
		}
	}
}
