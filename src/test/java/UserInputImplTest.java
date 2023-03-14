import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputImplTest {

    String initialString = "one two three";
    InputStream inputStream = new ByteArrayInputStream(initialString.getBytes());
    UserInput input = new UserInputImpl(inputStream);

    @Test
    void test_input() {
        String text = input.input();
        assertEquals(text, initialString);
    }
}