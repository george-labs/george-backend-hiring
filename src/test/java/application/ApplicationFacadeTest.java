package application;

import application.infrastructure.config.StopWordsConfig;
import application.infrastructure.config.file.StopWordsConfigFile;
import application.infrastructure.input.InputFactory;
import application.infrastructure.output.Output;
import application.output.ConsoleOutputMock;
import org.junit.jupiter.api.Test;

import static application.constants.ApplicationConstants.RESOURCE_FILENAME;

class ApplicationFacadeTest {

    @Test
    void shouldNotThrowExceptionOnInputWhenNotExistingFileNameInArrayPassed() {
        // given
        final InputFactory inputFactory = new InputFactory();
        final Output output = new ConsoleOutputMock();
        final StopWordsConfig stopWordsConfig = new StopWordsConfigFile(RESOURCE_FILENAME);
        final ApplicationFacade applicationFacade = new ApplicationFacade(inputFactory, output, stopWordsConfig);
        final String[] args = new String[] {"someFile"};

        // when
        applicationFacade.countWords(args);

        // then
    }
}