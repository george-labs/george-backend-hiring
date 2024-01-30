package application;

import application.infrastructure.config.StopWordsConfig;
import application.infrastructure.config.file.StopWordsConfigFile;
import application.infrastructure.input.Input;
import application.infrastructure.output.Output;
import application.input.ScannerInputMock;
import application.output.ConsoleOutputMock;
import org.junit.jupiter.api.Test;

import static application.constants.ApplicationConstants.RESOURCE_FILENAME;

class ApplicationFacadeTest {

    @Test
    void shouldNotThrowExceptionOnInput() {
        // given
        final Input input = new ScannerInputMock();
        final Output output = new ConsoleOutputMock();
        final StopWordsConfig stopWordsConfig = new StopWordsConfigFile(RESOURCE_FILENAME);
        final ApplicationFacade applicationFacade = new ApplicationFacade(input, output, stopWordsConfig);

        // when
        applicationFacade.countWords();

        // then
    }

}