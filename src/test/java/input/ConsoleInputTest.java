package input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sentence.Sentence;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleInputTest {
    @Test
    public void Input_empty(){
        var test_input = "";
        String expected = null;
        InputStream input = new ByteArrayInputStream(test_input.getBytes());
        var consoleInput = new ConsoleInput("Test message:", input);
        Assertions.assertEquals(expected, consoleInput.getString());
    }

    @Test
    public void Input_newline(){
        var test_input = "\n";
        String expected = "";
        InputStream input = new ByteArrayInputStream(test_input.getBytes());
        var consoleInput = new ConsoleInput("Test message:", input);
        Assertions.assertEquals(expected, consoleInput.getString());
    }

    @Test
    public void InputTest(){
        var test_input = "foo bar";
        var expected = "foo bar";
        InputStream input = new ByteArrayInputStream(test_input.getBytes());
        var consoleInput = new ConsoleInput("Test message:", input);
        Assertions.assertEquals(expected, consoleInput.getString());
    }
}
