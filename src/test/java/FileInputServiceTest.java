import exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.FileInputService;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileInputServiceTest {

    final private static String VALID_TEST_PATH = "src/test/resources/testFile.txt";
    final private static String INVALID_TEST_PATH = "invalidFile.txt";

    FileInputService fileInputService;

    @Test
    public void testGetUserInputWithValidInput() {
        fileInputService = new FileInputService(VALID_TEST_PATH);
        String userInput = fileInputService.getUserInput();

        Assertions.assertEquals("Here is a test file", userInput);
    }

    @Test
    public void testGetUserInputWithInvalidInput() {
        fileInputService = new FileInputService(INVALID_TEST_PATH);

        assertThrows(InvalidInputException.class, () -> fileInputService.getUserInput());
    }
}

