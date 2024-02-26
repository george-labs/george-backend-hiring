package wordcount.output;

import counter.WordCountResult;

public interface OutputProvider {
	
	void output(WordCountResult count);

}
