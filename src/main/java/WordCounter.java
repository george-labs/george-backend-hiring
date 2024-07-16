import java.util.Collection;
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
		return extractWords(sentence, null);
	}

	/**
	 * 
	 * @param sentence
	 * @param container the collection can also be null
	 * @return
	 */
	public int extractWords(final String sentence, final Collection<String> container) {
		final Matcher m = wordPattern.matcher(sentence);
		int wordsCount = 0;
		while (m.find()) {
			final String word = m.group();
			if (this.stopWords.contains(word)) {
				logger.log(Level.FINER, "skip {0}", word);
			} else {
				if (container != null)
					container.add(word);
				++wordsCount;
			}
		}
		if (container == null)
			logger.log(Level.FINEST, "sentence '{0}' => count {1}", new Object[] {sentence, wordsCount});
		else
			logger.log(Level.FINEST, "sentence '{0}' => count {1} container size {1}", new Object[] {sentence, wordsCount, container.size()});
		return wordsCount;
	}
}
