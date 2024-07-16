import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
	final static Logger logger = Logger.getLogger(WordCounter.class.getName());
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
				logger.log(Level.FINER, "skip {0}", word);
			} else {
				++wordsCount;
			}
		}
		logger.log(Level.FINEST, "sentence '{0}' => count {1}", new Object[] {sentence, wordsCount});
		return wordsCount;

		// Simple Alternative: return extractWords(sentence).size();
	}

	public List<String> extractWords(final String sentence) {
		final List<String> result = new LinkedList<String>();
		final Matcher m = wordPattern.matcher(sentence);
		while (m.find()) {
			final String word = m.group();
			if (this.stopWords.contains(word)) {
				logger.log(Level.FINER, "skip {0}", word);
			} else {
				result.add(word);
			}
		}
		logger.log(Level.FINEST, "sentence '{0}' => container size {1}", new Object[] {sentence, result.size()});
		return result;
	}
}
