package input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserInputReaderTest {
    @Test
    public void testReadUserInput() {
        String inputString = "dummy text";
        var inputStream = new ByteArrayInputStream(inputString.getBytes());

        String readOutput = new UserInputReader(inputStream).getInputText();

        Assertions.assertEquals(inputString, readOutput);
    }

    @Test
    public void testReadNoUserInput() {
        String inputString = "";
        var inputStream = new ByteArrayInputStream(inputString.getBytes());

        String readOutput = new UserInputReader(inputStream).getInputText();

        Assertions.assertNull(readOutput);
    }

    @Test
    public void testReadNullStream() {
        InputStream inputStream = null;

        String readOutput = new UserInputReader(inputStream).getInputText();

        Assertions.assertNull(readOutput);
    }
}
