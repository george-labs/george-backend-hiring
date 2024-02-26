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
		
	    InputProvider inputProvider = new ConsoleInputProvider();
	    
	    Filter regexFilter =  new RegexFilter();
	    List<Filter> filters = new ArrayList<>();
	    filters.add(regexFilter);
	    
	    Counter counter = new WordCounter(inputProvider, filters);
	    var wordCountResult = counter.count();
	    
	    OutputProvider outputProvider = new ConsoleOutputProvider();
	    outputProvider.output(wordCountResult);
	    
	}
	
}
