import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCountITest {

    InputStream stdin = System.in;
    WordCountI wordCountI = new WordCountI();

    @AfterEach
    public void cleanUp() {
        System.setIn(stdin);
    }

    @Test
    public void when_valid_input_word_count_printed() {
        System.setIn(new ByteArrayInputStream("Mary had a little lamb".getBytes()));

        int countI = wordCountI.wordCountI();

        assertEquals(5, countI);

    }

    @Test
    public void when_number_in_input_runtime_exc_thrown() {
        System.setIn(new ByteArrayInputStream("Mary9 had a little lamb".getBytes()));

        assertThrows(RuntimeException.class, wordCountI::wordCountI, "The input string contains invalid character(s)!");
    }

    @Test
    public void when_blank_input_runtime_exc_thrown() {

        System.setIn(new ByteArrayInputStream(" ".getBytes()));

        assertThrows(RuntimeException.class, wordCountI::wordCountI, "The input string is blank!");
    }



}
