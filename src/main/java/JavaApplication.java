public class JavaApplication {
	public static void main(final String[] args) {
		// read a line and count the number of words inside
		System.out.print("Enter text: ");
		final String input = System.console().readLine();
		final WordCounter wordCounter = new WordCounter();
		System.out.printf("Number of words: %d\n", wordCounter.countWords(input));
	}
}
