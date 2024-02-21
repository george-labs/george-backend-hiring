package sourceprovider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleTextProviderTest {

    @Test
    public void testConsole() {
        final String INPUT_STRING = "this is some dummy text";
        InputStream inputStream = new ByteArrayInputStream(INPUT_STRING.getBytes());

        TextProvider textProvider = new ConsoleTextProvider(inputStream, System.out);

        String resultString = textProvider.provide();

        Assertions.assertEquals(INPUT_STRING, resultString);
    }
}
