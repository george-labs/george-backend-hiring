package application;

import application.infrastructure.input.Input;
import application.infrastructure.output.Output;
import application.input.ScannerInputMock;
import application.output.ConsoleOutputMock;
import org.junit.jupiter.api.Test;

class ApplicationFacadeTest {

    @Test
    void shouldNotThrowExceptionOnInput() {
        // given
        final Input input = new ScannerInputMock();
        final Output output = new ConsoleOutputMock();
        final ApplicationFacade applicationFacade = new ApplicationFacade(input, output);

        // when
        applicationFacade.countWords();

        // then
    }

}