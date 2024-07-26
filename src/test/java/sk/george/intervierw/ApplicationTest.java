package sk.george.intervierw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import sk.george.intervierw.io.input.TestConsoleInputHandler;
import sk.george.intervierw.io.input.TestFileInputHandler;
import sk.george.intervierw.io.output.OutputHandler;
import sk.george.intervierw.io.output.TestOutputHandler;
import sk.george.intervierw.word_counter.WordCounter;

class ApplicationTest {

    @Test
    void run_printsWordsCount_inputFromUser() {
        // Init data
        TestOutputHandler outputHandler = new TestOutputHandler();
        String userInput = "Mary had a little lamb";
        Application application = createApp(userInput, null, outputHandler);

        // Start the application
        application.run(null);
        // Assert the result
        assertNotNull(outputHandler.getMessages());
        assertEquals(2, outputHandler.getMessages().size());
        assertEquals("Number of words: 5", outputHandler.getMessages().get(1));
    }

    private Application createApp(String mockInput, List<String> mockInputs, OutputHandler outputHandler) {
        return new Application(
                new TestConsoleInputHandler(mockInput),
                new TestFileInputHandler(mockInputs),
                outputHandler,
                new WordCounter()
        );
    }
}
