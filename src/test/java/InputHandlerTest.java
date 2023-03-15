import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputHandlerTest {

    private static final String VALID_INPUT = "Mary had a little lamb";
    private static final String NOT_VALID_INPUT = "\n";

    @Test
    void readValidInput() {
        InputStream in = new ByteArrayInputStream(VALID_INPUT.getBytes());
        System.setIn(in);

        assertEquals(VALID_INPUT, InputHandler.readInput(in));
    }

    @Test
    void shouldValidateText() {
        InputStream in = new ByteArrayInputStream(NOT_VALID_INPUT.getBytes());
        System.setIn(in);

        assertThrows(WordNotValidException.class, () -> InputHandler.validateText(NOT_VALID_INPUT), "Your text is not valid");
    }


}