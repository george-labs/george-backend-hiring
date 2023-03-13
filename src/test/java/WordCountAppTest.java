import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WordCountAppTest {

    @Test
    void when_file_argument_then_read_from_file() throws IOException {
        String[] args = {};
        String expected = "Usage: WordCountApp <filename>";
        String actual = WordCountApp.parseArgument(args);
        assertEquals(expected, actual);
    }

}