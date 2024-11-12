import mock.InputServiceTestImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.InputService;
import service.WordCounterService;

public class IntegrationTest {

    @Test
    void shouldCountWordsFromInputTest() {
        InputService inputService = new InputServiceTestImpl();
        int count = WordCounterService.wordCounter(inputService.getInput());
        Assertions.assertEquals(5, count);
    }
}
