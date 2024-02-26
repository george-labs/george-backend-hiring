package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordFilterService implements FilterService {
	
	List<Filter> filters = new ArrayList<>();
	
	public WordFilterService() {}
	
	@Override
	public List<String> apply(String words) {
		var wordList = Arrays.asList(words.strip().split(" "));
		for (var filter : this.filters) {
			wordList = filter.filter(wordList);
		}
		return wordList;
	}
	
	public void registerFilter(Filter filter) {
		this.filters.add(filter);
	}

}
