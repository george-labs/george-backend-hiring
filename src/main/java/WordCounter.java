import java.util.regex.Pattern;

public class WordCounter {
	final Pattern wordPattern = Pattern.compile("([a-zA-Z]+)");
	
	// maybe we need some constructors with different patterns later

	public long countWords(final String sentence) {
		return wordPattern.matcher(sentence).results().count();
	}
}
