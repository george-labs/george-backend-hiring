import mock.StopWordsInputServiceMock;
import mock.UserInputServiceMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.InputService;
import service.StopWordsLoader;
import service.WordCounterService;

import java.io.IOException;

public class IntegrationTest {

    @Test
    void shouldCountWordsFromInputTest() throws IOException {
        InputService inputService = new UserInputServiceMock();
        int count = WordCounterService.wordCounter(inputService.getInput());
        Assertions.assertEquals(5, count);
    }

    @Test
    void shouldSkipStopWordsFromInputTest() throws IOException {
        InputService userInputService = new UserInputServiceMock();
        InputService fileInputService = new StopWordsInputServiceMock();

        int count = WordCounterService.wordCounter(
                userInputService.getInput(),
                StopWordsLoader.getStopWords(fileInputService.getInput()));
        Assertions.assertEquals(4, count);
    }
}
