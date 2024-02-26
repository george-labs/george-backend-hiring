import java.util.Scanner;

import wordcount.input.ConsoleInputProvider;
import wordcount.input.InputProvider;

public class JavaApplication {
	
	public static void main (String[] args) {
		
		// Input provider
	    InputProvider inputProvider = new ConsoleInputProvider();
	    
	   // Word counter 
	    var wordCount = getWordCount(inputProvider.getInput());
	    
	    // Output Provider
	    var output = String.format("Number of words: %s", wordCount);
	    System.out.println(output);
	    
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
