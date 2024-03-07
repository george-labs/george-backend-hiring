package wordcount.ui;

public class UserInputReaderFactory {
	public static UserInputReader getInputReader(String[] args) {
		if (args != null && (args.length > 0)) {
			FileInputReader fileInputReader = new FileInputReader();
			fileInputReader.setFileName(args[0]);
			return fileInputReader;
		}
		return new ConsoleInputReader();

	}
}
