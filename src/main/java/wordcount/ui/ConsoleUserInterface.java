package wordcount.ui;

public class ConsoleUserInterface implements UserInterface {

	private UserInputReader userInputReader;
	private UserOutputWriter userOutputWriter;

	public ConsoleUserInterface() {
		userInputReader = new ConsoleReader();
		userOutputWriter = new ConsoleWriter();
	}

	@Override
	public String readUserInput() {
		return userInputReader.readUserInput();
	}

	@Override
	public void presentOutput(long output) {
		userOutputWriter.presentOutput(output);
	}

}
