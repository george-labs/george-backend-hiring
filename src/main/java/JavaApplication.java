import java.util.ArrayList;
import java.util.List;

import counter.Counter;
import counter.WordCounter;
import filter.Filter;
import filter.RegexFilter;
import wordcount.input.ConsoleInputProvider;
import wordcount.input.InputProvider;
import wordcount.output.ConsoleOutputProvider;
import wordcount.output.OutputProvider;

public class JavaApplication {
	
	public static void main (String[] args) {
		
		// Input provider
	    InputProvider inputProvider = new ConsoleInputProvider();
	    
	   // Word counter 
	    Filter regexFilter =  new RegexFilter();
	    List<Filter> filters = new ArrayList<>();
	    filters.add(regexFilter);
	    
	    
	    Counter counter = new WordCounter(inputProvider, filters);
	    var wordCount = counter.count();
	    
	    //var wordCount = getWordCount(inputProvider.getInput());
	    
	    // Output Provider
	    OutputProvider outputProvider = new ConsoleOutputProvider();
	    outputProvider.output(wordCount);
	    
	}
	
	static int getWordCount(String input) {
		if (input.isEmpty()) {
			return 0;
		}
	
		var words = input.strip().split(" ");
	
		var count = 0;
		for (var wrod : words) {
			if (isValidWord(wrod)) {
				count++;
			}
		}
		
		return count;
	}
	
	private static boolean isValidWord(String word) {
		return word.matches("^[a-zA-Z]+$");
	}
}
