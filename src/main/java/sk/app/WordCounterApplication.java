package sk.app;

public class WordCounterApplication implements WordCounter {


	@Override
	public int countWords(String text) {
		if (text == null) {
			return 0;
		}
		String[] tokens = text.split("\\s+");

		int counter = 0;
		for (String token : tokens) {
			if (isWord(token)) {
				counter++;
			}
		}

		return counter;
	}

	private boolean isWord(String token) {
		if (token.isBlank()) {
			return false;
		}
		for (int i = 0; i < token.length(); i++) {
			char character = token.charAt(i);
			if (!Character.isLetter(character)) {
				return false;
			}
		}
		return true;
	}
}
