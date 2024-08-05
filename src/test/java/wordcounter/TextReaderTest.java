package wordcounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static wordcounter.InputUtils.provideInput;


public class TextReaderTest {

    private final TextReader reader = new TextReader();

    @Test
    void givenName_whenReadFromInput_thenReturnCorrectResult() {
        String providedInput = "Mary had a little lamb";
        provideInput(providedInput);
        String resultInput = reader.readText();
        assertEquals(providedInput, resultInput);
    }


}
