package wordcount.ui;

import wordcount.counter.WordCountResult;

public class ConsoleWriter implements UserOutputWriter {

	protected static final String OUTPUT_PROMPT = "Number of words: ";
	protected static final String UNIQUE_OUTPUT_PROMPT = ", unique: ";

	@Override
	public void presentOutput(WordCountResult output) {
		System.out.println(OUTPUT_PROMPT + output.getNumberOfWords() + UNIQUE_OUTPUT_PROMPT  + output.getNumberOfUniqueWords());
	}

}
