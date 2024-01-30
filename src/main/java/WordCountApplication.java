import application.ApplicationFacade;
import application.infrastructure.input.ScannerInput;
import application.infrastructure.input.Input;
import application.infrastructure.output.ConsoleOutput;
import application.infrastructure.output.Output;

import static application.constants.ApplicationConstants.CONSOLE_INPUT_TEXT;
import static application.constants.ApplicationConstants.CONSOLE_OUTPUT_TEXT;

public class WordCountApplication {
    public static void main(String[] args) {
        final Input input = new ScannerInput(CONSOLE_INPUT_TEXT);
        final Output output = new ConsoleOutput(CONSOLE_OUTPUT_TEXT);
        final ApplicationFacade applicationFacade = new ApplicationFacade(input, output);
        applicationFacade.countWords();
    }
}
