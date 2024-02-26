import counter.Counter;
import counter.WordCounter;
import filter.Filter;
import filter.FilterService;
import filter.RegexFilter;
import filter.StopWordsFilter;
import filter.WordFilterService;
import wordcount.input.ConsoleInputProvider;
import wordcount.input.FileInputProvider;
import wordcount.input.InputProvider;
import wordcount.output.ConsoleOutputProvider;
import wordcount.output.OutputProvider;

public class JavaApplication {
	
	public static void main (String[] args) {
		
		InputProvider inputProvider = null;
		if (args.length != 0) {
			if (args.length > 1) {
				var errorMessage = String.format("More than 1 argument provided. Arguments provided: %s", 
						args.length);
				throw new RuntimeException(errorMessage);
			}
			var fileName = args[0];
			inputProvider = new FileInputProvider(fileName);
		} else {
			inputProvider = new ConsoleInputProvider();
		}
		
	    Filter regexFilter =  new RegexFilter();
	    Filter stopwordsFilter = new StopWordsFilter();
	    FilterService wordFilterService = new WordFilterService();
	    wordFilterService.registerFilter(regexFilter);
	    wordFilterService.registerFilter(stopwordsFilter);
	    
	    Counter counter = new WordCounter(inputProvider, wordFilterService);
	    var wordCountResult = counter.count();
	    
	    OutputProvider outputProvider = new ConsoleOutputProvider();
	    outputProvider.output(wordCountResult);
	    
	}
	
}
