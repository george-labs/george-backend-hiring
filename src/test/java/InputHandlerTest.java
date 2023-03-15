import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputHandlerTest {

    private static final String VALID_INPUT = "Mary had a little lamb";
    private static final String NOT_VALID_INPUT = "";

    @Test
    void readValidInput() {
        InputStream in = new ByteArrayInputStream(VALID_INPUT.getBytes());
        System.setIn(in);

        assertEquals(VALID_INPUT, InputHandler.readInput());
    }
}