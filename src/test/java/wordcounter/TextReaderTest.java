package wordcounter;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TextReaderTest {

    private final TextReader reader = new TextReader();

    @Test
    void givenName_whenReadFromInput_thenReturnCorrectResult() {
        String providedInput = "Mary had a little lamb";
        provideInput(providedInput);
        String resultInput = reader.readText();
        assertEquals(providedInput, resultInput);
    }

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

}
