import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
	final Pattern wordPattern = Pattern.compile("([a-zA-Z]+)");
	final Set<String> stopWords;
	
	// maybe we need some constructors with different patterns later

	public WordCounter(final List<String> stopwords) {
		stopWords = Set.copyOf(stopwords);
	}

	public int countWords(final String sentence) {
		final Matcher m = wordPattern.matcher(sentence);
		int wordsCount = 0;
		while (m.find()) {
			final String word = m.group();
			if (this.stopWords.contains(word)) {
				Logger.getLogger(WordCounter.class.getName()).log(Level.FINER, "skip {0}", word);
			} else {
				++wordsCount;
			}
		}
		return wordsCount;
	}
}
