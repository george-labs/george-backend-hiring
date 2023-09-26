package file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileHandlerTest {

    @Test
    public void testFileNotFound() {
        String invalidFileName = "doesntexist.txt";
        String failMessage = "readFileToString() should have thrown FileHandlingException when file not found";

        Assertions.assertThrows(
                FileHandlingException.class,
                () -> new FileHandler().readFileToString(invalidFileName),
                failMessage);
    }

    @Test
    public void testReadFileIntoString() {
        String inputFileName = "filehandler_test_input.txt";

        String result = new FileHandler().readFileToString(inputFileName);

        Assertions.assertEquals("the\na\non\noff", result);
    }
}
