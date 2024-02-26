import counter.Counter;
import counter.WordCounter;
import filter.Filter;
import filter.RegexFilter;
import filter.StopWordsFilter;
import filter.WordFilterService;
import wordcount.input.ConsoleInputProvider;
import wordcount.input.InputProvider;
import wordcount.output.ConsoleOutputProvider;
import wordcount.output.OutputProvider;

public class JavaApplication {
	
	public static void main (String[] args) {
		
	    InputProvider inputProvider = new ConsoleInputProvider();
	    
	    Filter regexFilter =  new RegexFilter();
	    Filter stopwordsFilter = new StopWordsFilter();
	    WordFilterService wordFilterService = new WordFilterService();
	    wordFilterService.registerFilter(regexFilter);
	    wordFilterService.registerFilter(stopwordsFilter);
	    
	    Counter counter = new WordCounter(inputProvider, wordFilterService);
	    var wordCountResult = counter.count();
	    
	    OutputProvider outputProvider = new ConsoleOutputProvider();
	    outputProvider.output(wordCountResult);
	    
	}
	
}
