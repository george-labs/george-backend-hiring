import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

record WordsCountInfo(int wordsCount, int uniqueWordsCount) {
}

public class JavaApplication {

	public static WordsCountInfo getWordsCount(String s) {
		return getWordsCount(s, Collections.emptySet());
	}

	public static WordsCountInfo getWordsCount(String s, Set<String> stopwords) {

		if (s == null)
			return new WordsCountInfo(0, 0);

		int wordsCount = 0;
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
			uniqueWords.add(tmp);
		}
		return new WordsCountInfo(wordsCount, uniqueWords.size());
	}

	public static Set<String> getStopwords(String resourcePath) {
		try {
			ClassLoader classLoader = JavaApplication.class.getClassLoader();
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

	public static void main(String[] args) {

		Set<String> stopwords = getStopwords("stopwords.txt");
		String text = null;

		if (args.length != 0) {
			if (args.length != 1) {
				throw new IllegalArgumentException(
						"Only one argument is allowed. It is path for file with text. If not entered, then the application will ask for text.");
			}
			text = getText(Path.of(args[0]));
		} else {
			System.out.print("Enter text: ");
			try (Scanner scanner = new Scanner(System.in);) {
				text = scanner.nextLine();
			}
		}

		WordsCountInfo wordsCountInfo = getWordsCount(text, stopwords);
		System.out.println(
				"Number of words: " + wordsCountInfo.wordsCount() + ", unique: " + wordsCountInfo.uniqueWordsCount());
	}
}
