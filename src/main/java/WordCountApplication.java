import application.ApplicationFacade;
import application.infrastructure.config.StopWordsConfig;
import application.infrastructure.config.file.StopWordsConfigFile;
import application.infrastructure.input.*;
import application.infrastructure.output.ConsoleOutput;
import application.infrastructure.output.Output;

import static application.infrastructure.InfrastructureConstants.RESOURCE_FILENAME;


public class WordCountApplication {
    public static void main(String[] args) {
        final InputFactory inputFactory = new InputFactory();
        final Output output = new ConsoleOutput();
        final StopWordsConfig stopWordsConfig = new StopWordsConfigFile(RESOURCE_FILENAME);
        final ApplicationFacade applicationFacade = new ApplicationFacade(inputFactory, output, stopWordsConfig);
        applicationFacade.countWords(args);
    }
}
