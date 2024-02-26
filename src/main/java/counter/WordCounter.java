package counter;
import filter.FilterService;
import wordcount.input.InputProvider;

public class WordCounter implements Counter{
	
	private InputProvider inputProvider;
	
	private FilterService filterService;
	
	public WordCounter(InputProvider inputProvider, FilterService filterService) {
		this.inputProvider = inputProvider;
		this.filterService = filterService;
	}
	
	@Override
	public WordCountResult count() {
		var words = this.inputProvider.getInput();
		if (words.isEmpty()) {
			return new WordCountResult(0);
		}
		
		var wordList = this.filterService.apply(words);
		return new WordCountResult(wordList.size());
	}


}
