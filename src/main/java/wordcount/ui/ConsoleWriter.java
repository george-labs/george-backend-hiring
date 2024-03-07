package wordcount.ui;

public class ConsoleWriter implements UserOutputWriter {

	protected static final String OUTPUT_PROMPT = "Number of words: ";

	@Override
	public void presentOutput(long output) {
		System.out.println(OUTPUT_PROMPT + output);
	}

}
