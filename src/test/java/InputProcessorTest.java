import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class InputProcessorTest {

    @Test
    void testInputString() {
        var scanner = new InputProcessor(new ByteArrayInputStream("data".getBytes()));
        var input = scanner.readInput();
        Assertions.assertEquals("data", input);
    }
}