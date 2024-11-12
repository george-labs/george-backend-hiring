import constant.FilePaths;
import mock.UserInputServiceMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.InputService;
import service.StopWordsLoader;
import service.WordCounterService;
import service.impl.FileInputService;

import java.io.IOException;
import java.util.Set;

public class IntegrationTest {

    @Test
    void shouldCountWordsFromInputTest() throws IOException {
        InputService inputService = new UserInputServiceMock();
        int count = WordCounterService.wordCounter(inputService.getInput());
        Assertions.assertEquals(6, count);
    }

    @Test
    void shouldSkipStopWordsFromInputTest() throws IOException {
        InputService userInputService = new UserInputServiceMock();
        InputService fileInputService = new FileInputService(FilePaths.STOP_WORDS_FILE);

        final Set<String> stopWords = StopWordsLoader.getStopWords(fileInputService.getInput());
        int count = WordCounterService.wordCounter(
                userInputService.getInput(),
                stopWords);
        Assertions.assertEquals(5, count);
    }

    @Test
    void shouldReadInputsFromFileTest() throws IOException {
        InputService userInputService = new FileInputService("src/test/resources/InputText.txt");
        InputService fileInputService = new FileInputService(FilePaths.STOP_WORDS_FILE);

        int count = WordCounterService.wordCounter(
                userInputService.getInput(),
                StopWordsLoader.getStopWords(fileInputService.getInput()));
        Assertions.assertEquals(4, count);
    }

    @Test
    void shouldThrowExceptionWhileReadingInputFileTest() {
        try {
            InputService userInputService = new FileInputService("resources/InputText.txt");
            userInputService.getInput();
            Assertions.fail();
        } catch (IOException ex) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    void shouldNotReadStopWordsFileTest() {
        try {
            InputService fileInputService = new FileInputService("src/main/resources/stopwords_notexist.txt");
            fileInputService.getInput();
            Assertions.fail();
        } catch (IOException ex) {
            Assertions.assertTrue(true);
        }
    }
}
