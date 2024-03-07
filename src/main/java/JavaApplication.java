import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication {
	public static void main(String[] args) {
		// first rough prototype implementation, just for the integration tests
		
		// ui
		// 1. prompt
		System.out.print("Enter text: ");
		// 2. read input
		String line;
		try (Scanner scanner = new Scanner(System.in)) {
			line = scanner.nextLine();
		}
		
		// bl
		// 3. count words
		String[] wordCandidates = line.split("/s");
		Arrays.stream(wordCandidates);
		
		// ui
		// 4. present output
	}
}
