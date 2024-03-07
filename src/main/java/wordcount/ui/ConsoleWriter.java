package wordcount.ui;

public class ConsoleWriter implements UserOutputWriter {

	protected static final String OUTPUT_PROMPT = "Number of words: ";

	// TODO define output stream in constructor instead of hardcoding System.out
	
	@Override
	public void presentOutput(long output) {
		System.out.println(OUTPUT_PROMPT + output);
	}

}
