import dto.WordCountResultDto;
import io.IFileHandler;
import io.LocalFileHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import service.WordCountService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCountServiceTest {

    private static final String INPUT_FILENAME = "input.txt";
    private static final String INPUT2_FILENAME = "input2.txt";

    InputStream stdin = System.in;
    IFileHandler fileHandler = new LocalFileHandler();
    WordCountService wordCountService = new WordCountService(fileHandler);

    @AfterEach
    public void cleanUp() {
        System.setIn(stdin);
    }

    @Test
    public void when_valid_input_with_one_stop_word_then_word_count_printed() {
        String stopWord = "a";
        System.setIn(new ByteArrayInputStream(("Mary had " + stopWord + " little lamb two two").getBytes()));

        WordCountResultDto result = wordCountService.countWords(null);

        assertEquals(6, result.getCount());
        assertEquals(5, result.getUniqueCount());

    }

    @Test
    public void when_valid_input_from_file_with_one_stop_word_then_word_count_printed() {
        WordCountResultDto result = wordCountService.countWords(INPUT_FILENAME);

        assertEquals(6, result.getCount());
        assertEquals(5, result.getUniqueCount());

    }

    @Test
    public void when_valid_input_from_input2_file_then_word_count_printed() {
        WordCountResultDto result = wordCountService.countWords(INPUT2_FILENAME);

        assertEquals(7, result.getCount());
        assertEquals(6, result.getUniqueCount());

    }

    @Test
    public void when_only_stop_words_then_word_count_printed() {
        System.setIn(new ByteArrayInputStream("the a on off".getBytes()));

        WordCountResultDto result = wordCountService.countWords(null);

        assertEquals(0, result.getCount());
        assertEquals(0, result.getUniqueCount());
    }

    @Test
    public void when_valid_input_then_word_count_printed() {
        System.setIn(new ByteArrayInputStream("Mary had six little lambs".getBytes()));

        WordCountResultDto result = wordCountService.countWords(null);

        assertEquals(5, result.getCount());
        assertEquals(5, result.getUniqueCount());

    }

    @Test
    public void when_number_in_input_runtime_exc_thrown() {
        System.setIn(new ByteArrayInputStream("Mary9 had a little lamb".getBytes()));

        assertThrows(RuntimeException.class, () -> wordCountService.countWords(null), "The input string contains invalid character(s)!");
    }

    @Test
    public void when_blank_input_then_runtime_exc_thrown() {

        System.setIn(new ByteArrayInputStream(" ".getBytes()));

        assertThrows(RuntimeException.class, () -> wordCountService.countWords(null), "The input string is blank!");
    }

    @Test
    public void when_wrong_input_file_name_then_runtime_exc_thrown() {
        assertThrows(RuntimeException.class, () -> wordCountService.countWords("wrong_file_input.txt"), "The specified file could not be found!");
    }

}