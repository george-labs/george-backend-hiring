import java.util.logging.Logger;

/**
 * Processing of command line arguments.
 * -index ... an output of an index is desired.
 * everything else is a filename but only the last one counts.
 */
public class CLIParser {
	private static final Logger logger = Logger.getLogger(CLIParser.class.getName());
	private boolean isIndexDesired = false;
	private String filename = null;

	public CLIParser(String... args) {
		for (String arg : args) {
			if ("-index".equals(arg))
				isIndexDesired = true;
			else
				filename = arg;
		}
	}
	public boolean isIndexDesired() { return isIndexDesired; }
	public String filename() { return filename; }
	public boolean isInputReadFromStdin() { return filename == null; }
	public boolean isInputReadFromFile()  { return filename != null; }
}
