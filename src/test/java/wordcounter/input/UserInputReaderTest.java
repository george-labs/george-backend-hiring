package wordcounter.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static wordcounter.input.InputUtils.provideInput;


public class UserInputReaderTest {

    private final UserInputReader reader = new UserInputReader();

    @Test
    void readInput_providedUserInput_correctResult() {
        String providedInput = "Mary had a little lamb";
        provideInput(providedInput);
        String resultInput = reader.readInput();
        assertEquals(providedInput, resultInput);
    }


}
