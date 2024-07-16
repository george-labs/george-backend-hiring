public class JavaApplication {
	public static void main(final String[] args) {
		System.out.print("Enter text: ");
		final String input = System.console().readLine();
		//int numberOfWords = 0;
		//Matcher m = wordPattern.matcher(input);
		//while (m.find())
		//	++numberOfWords;
		final WordCounter wordCounter = new WordCounter();
		System.out.printf("Number of words: %d\n", wordCounter.countWords(input));
	}
}
