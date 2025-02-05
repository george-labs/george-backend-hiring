import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaApplication {

	public static int getWordsCount(String s) {
		return getWordsCount(s, Collections.emptySet());
	}

	public static int getWordsCount(String s, Set<String> stopwords) {

		if (s == null)
			return 0;

		int res = 0;

		String[] ss = s.split("\\s");
		for_tmp: for (String tmp : ss) {
			if (tmp.trim().length() == 0)
				continue;
			for (char c : tmp.toCharArray()) {
				if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
					continue for_tmp;
				}
			}
			if (stopwords.contains(tmp)) {
				continue;
			}
			res++;
		}
		return res;
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

	public static void main(String[] args) {

		Set<String> stopwords = getStopwords("stopwords.txt");

		System.out.print("Enter text: ");
		String s = null;

		try (Scanner scanner = new Scanner(System.in);) {
			s = scanner.nextLine();
		}
		System.out.println("Number of words: " + getWordsCount(s, stopwords));
	}
}
