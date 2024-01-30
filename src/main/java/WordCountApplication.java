import application.ApplicationFacade;
import application.infrastructure.config.StopWordsConfig;
import application.infrastructure.config.file.StopWordsConfigFile;
import application.infrastructure.input.ScannerInput;
import application.infrastructure.input.Input;
import application.infrastructure.output.ConsoleOutput;
import application.infrastructure.output.Output;

import static application.constants.ApplicationConstants.*;

public class WordCountApplication {
    public static void main(String[] args) {
        final Input input = new ScannerInput(CONSOLE_INPUT_TEXT);
        final Output output = new ConsoleOutput(CONSOLE_OUTPUT_TEXT);
        final StopWordsConfig stopWordsConfig = new StopWordsConfigFile(RESOURCE_FILENAME);
        final ApplicationFacade applicationFacade = new ApplicationFacade(input, output, stopWordsConfig);
        applicationFacade.countWords();
    }
}
