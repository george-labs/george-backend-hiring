package com.erste.wordcounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {

	public static WordsCountInfo getWordsCount(String s) {
		return getWordsCount(s, false, Collections.emptySet());
	}

	public static WordsCountInfo getWordsCount(String s, boolean addIndex, Set<String> stopwords) {

		if (s == null)
			return new WordsCountInfo(0, 0, 0, Collections.emptyList());

		int wordsCount = 0;
		int totalLength = 0;
		Set<String> uniqueWords = new HashSet<>();

		String[] ss = s.split("[\\s,\\.\"':;]+");
		for_tmp: for (String tmp : ss) {
			if (tmp.trim().length() == 0)
				continue;
			boolean hasLetter = false;
			for (char c : tmp.toCharArray()) {
				if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == '-')) {
					continue for_tmp;
				}
				hasLetter = hasLetter || c != '-';
			}
			if (!hasLetter || stopwords.contains(tmp)) {
				continue;
			}
			wordsCount++;
			totalLength += tmp.length();
			uniqueWords.add(tmp);
		}
		List<String> index = null;
		if (addIndex) {
			index = new ArrayList<>(uniqueWords);
			Collections.sort(index, new LowercaseFirstComparator());

		}
		return new WordsCountInfo(wordsCount, uniqueWords.size(),
				wordsCount == 0 ? 0 : (double) totalLength / wordsCount, index);
	}

	public static Set<String> getStopwords(String resourcePath) {
		try {
			ClassLoader classLoader = WordCounter.class.getClassLoader();
			try (InputStream inputStream = classLoader.getResourceAsStream(resourcePath);
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
				if (inputStream == null) {
					throw new IOException("Resource not found: " + resourcePath);
				}
				return reader.lines().map(String::trim).collect(Collectors.toSet());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static String getText(Path path) {
		try {
			return Files.readString(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static String getUsage() {
		return """
				Allowed arguments:
				filename - path to filename from which text will processed. If not defined, then application will ask for the text.
				Allowed options:
				-indent - prints index of all counted words
				"""
				.stripIndent();
	}

	public static void main(String[] args) {

		Set<String> stopwords = getStopwords("stopwords.txt");
		String filepath = null;
		boolean index = false;
		String text = null;

		if (args.length != 0) {
			if (args.length > 2) {
				System.out.println(getUsage());
				return;
			}
			for (String arg : args) {
				if ("-index".equals(arg)) {
					if (index) {
						System.out.println(getUsage());
						return;
					}
					index = true;
					continue;
				}
				filepath = arg;
			}
		}

		if (filepath != null) {
			text = getText(Path.of(filepath));
		} else {
			System.out.print("Enter text: ");
			try (Scanner scanner = new Scanner(System.in);) {
				text = scanner.nextLine();
			}
		}

		WordsCountInfo wordsCountInfo = getWordsCount(text, index, stopwords);
		System.out.printf("Number of words: %d, unique: %d; average word length: %.2f characters\n",
				wordsCountInfo.wordsCount(), wordsCountInfo.uniqueWordsCount(), wordsCountInfo.averageWordLength());
		if (index) {
			System.out.println("Index:");
			for (String word : wordsCountInfo.index()) {
				System.out.println(word);
			}
		}
	}
}
