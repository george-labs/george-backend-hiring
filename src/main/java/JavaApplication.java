import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class JavaApplication {
	
	protected static final String INPUT_PROMPT = "Enter text: ";
	protected static final String OUTPUT_PROMPT = "Number of words: ";
	
	private static boolean filter(String candidate) {
		return candidate.matches("[a-zA-Z]+");
	}
	
	public static void main(String[] args) {
		// first rough prototype implementation, just for the integration tests

		// ui
		// 1. prompt
		System.out.print(INPUT_PROMPT);
		// 2. read input
		String line;
		try (Scanner scanner = new Scanner(System.in)) {
			line = scanner.nextLine();
		}

		// bl
		// 3. count words
		String[] wordCandidates = line.split("\\s");
		Stream<String> wordCandidatesStream = Arrays.stream(wordCandidates);
		wordCandidatesStream = wordCandidatesStream.filter(c -> filter(c));

		long wordCount = wordCandidatesStream.count(); // TODO refactor -> regexp compile

		// ui
		// 4. present output
		System.out.println(OUTPUT_PROMPT + wordCount);
	}
}
