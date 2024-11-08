import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInputWordsTest {
    @Test
    void testGetUserInput() {
        String simulatedInput = "Mary had a little lamb";
        InputStream inStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inStream);

        List<String> result = new UserInputWordsProvider().provideWords();

        // Assert the result
        assertEquals(5, result.size());
        assertTrue(result.contains("Mary"));

        // Reset System.in to its original state
        System.setIn(System.in);
    }
}
