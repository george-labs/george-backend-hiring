import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TextFileReaderTest {

    private final static String STOPWORDS_FILE = "src/test/resources/stopwords.txt";
    private final static String EMPTY_STOPWORDS = "src/test/resources/stopwords_empty.txt";

    private final static String MYTEXT_FILE = "src/test/resources/mytext.txt";

    private final static String MYTEXT_FILE_SPLITTED_LINES = "src/test/resources/mytext_splitted_lines.txt";

    private final static String MYTEXT_FILE_EMPTY = "src/test/resources/mytext_empty.txt";

    @Test
    void when_entering_filename_then_text_is_read() throws FileNotFoundException {
        String text = TextFileReader.read(MYTEXT_FILE, TextFileReader.JOIN_FUNCTION);
        Assertions.assertEquals("Mary had a little lamb", text);
    }

    @Test
    void when_entering_file_with_multiple_lines_return_single_line() throws FileNotFoundException {
        String text = TextFileReader.read(MYTEXT_FILE_SPLITTED_LINES, TextFileReader.JOIN_FUNCTION);
        Assertions.assertEquals("Mary had a little lamb", text);
    }

    @Test
    void when_file_is_empty_return_empty_string() throws FileNotFoundException {
        String text = TextFileReader.read(MYTEXT_FILE_EMPTY, TextFileReader.JOIN_FUNCTION);
        Assertions.assertEquals("", text);
    }

    @Test
    void when_stopwords_is_empty() throws IOException {
        String stopwords = TextFileReader.read(EMPTY_STOPWORDS, TextFileReader.JOIN_FUNCTION);
        Assertions.assertTrue(stopwords.isEmpty());
    }

    @Test
    void when_ask_for_stop_word_then_return_list() throws IOException {
        List<String> filterList = TextFileReader.read(STOPWORDS_FILE);
        Assertions.assertFalse(filterList.isEmpty());
    }
}
