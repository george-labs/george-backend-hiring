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
	public Integer count() {
		
		var words = this.inputProvider.getInput();
		if (words.isEmpty()) {
			return 0;
		}
		
		var wordList = Arrays.asList(words.strip().split(" "));
		for (var filter : this.filters) {
			wordList = filter.filter(wordList);
		}
		
		return wordList.size();
	}

}
