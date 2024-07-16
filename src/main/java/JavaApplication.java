public class JavaApplication {
	public static void main(final String[] args) throws Exception {
		final WordCounter wordCounter = new WordCounter();

		// read a line and count the number of words inside
		System.out.print("Enter text: ");
		final String input = System.console().readLine();
		System.out.printf("Number of words: %d\n", wordCounter.countWords(input));
	}
}
