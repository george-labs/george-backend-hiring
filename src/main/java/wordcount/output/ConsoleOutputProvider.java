package wordcount.output;

import counter.WordCountResult;

public class ConsoleOutputProvider implements OutputProvider {
	

	@Override
	public void output(WordCountResult result) {

	    var output = String.format("Number of words: %s", result.getCount());
	    System.out.println(output);
	}

}
