package wordcount.ui;

import wordcount.counter.WordCountResult;

public interface UserOutputWriter {
	public void presentOutput(WordCountResult output);
}
