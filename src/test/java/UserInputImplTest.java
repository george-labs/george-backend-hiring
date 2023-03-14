import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputImplTest {

    String inputString = "one two three";
    InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
    UserInput input = new UserInputImpl(inputStream);

    @Test
    void test_input() {
        String text = input.input();
        assertEquals(text, inputString);
    }
}