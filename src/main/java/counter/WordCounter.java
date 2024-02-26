package counter;
import java.util.Arrays;
import java.util.List;

import filter.Filter;
import wordcount.input.InputProvider;

public class WordCounter implements Counter{
	
	private InputProvider inputProvider;
	
	private List<Filter> filters;
	
	public WordCounter(InputProvider inputProvider, List<Filter> filters) {
		this.inputProvider = inputProvider;
		this.filters = filters;
		
	}
	
	@Override
	public WordCountResult count() {
		
		var words = this.inputProvider.getInput();
		if (words.isEmpty()) {
			return new WordCountResult(0);
		}
		
		var wordList = getFilteredResult(words);
		
		return new WordCountResult(wordList.size());
	}

	private List<String> getFilteredResult(String words) {
		var wordList = Arrays.asList(words.strip().split(" "));
		for (var filter : this.filters) {
			wordList = filter.filter(wordList);
		}
		return wordList;
	}

}
