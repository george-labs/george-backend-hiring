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
    public void when_valid_input_with_one_stop_word_then_word_count_printed() {
        String stopWord = "a";
        System.setIn(new ByteArrayInputStream(("Mary had " + stopWord + " little lamb").getBytes()));

        int countI = wordCountI.wordCountI();

        assertEquals(4, countI);

    }

    @Test
    public void when_only_stop_words_then_word_count_printed() {
        System.setIn(new ByteArrayInputStream("the a on off".getBytes()));

        int countI = wordCountI.wordCountI();

        assertEquals(0, countI);
    }

    @Test
    public void when_valid_input_then_word_count_printed() {
        System.setIn(new ByteArrayInputStream("Mary had six little lambs".getBytes()));

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
