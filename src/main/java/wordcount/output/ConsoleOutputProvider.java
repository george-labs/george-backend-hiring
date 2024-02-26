package wordcount.output;

public class ConsoleOutputProvider implements OutputProvider {
	

	@Override
	public void output(Integer count) {

	    var output = String.format("Number of words: %s", count);
	    System.out.println(output);
	}

}
