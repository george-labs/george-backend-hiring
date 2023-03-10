import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TextFileReaderTest {

    private final String STOPWORDS_FILE = "src/test/resources/stopwords.txt";
    private final String EMPTY_STOPWORDS = "src/test/resources/stopwords_empty.txt";

    @Test
    void when_entering_filename_then_text_is_read() throws FileNotFoundException {
        TextFileReader textFileReader = new TextFileReader("src/test/resources/mytext.txt");
        String text = textFileReader.read();
        Assertions.assertEquals("Mary had a little lamb", text);
    }

    @Test
    void when_entering_file_with_multiple_lines_return_single_line() throws FileNotFoundException {
        TextFileReader textFileReader = new TextFileReader("src/test/resources/mytext_splitted_lines.txt");
        String text = textFileReader.read();
        Assertions.assertEquals("Mary had a little lamb", text);
    }

    @Test
    void when_file_is_empty_return_empty_string() throws FileNotFoundException {
        TextFileReader textFileReader = new TextFileReader("src/test/resources/mytext_empty.txt");
        String text = textFileReader.read();
        Assertions.assertEquals("", text);
    }

    @Test
    void when_stopwords_is_empty() throws IOException {
        TextFileReader stopWordReader = new TextFileReader(EMPTY_STOPWORDS);
        String numberOfWords = stopWordReader.read();
        Assertions.assertEquals("", numberOfWords);
    }

    @Test
    void when_ask_for_stop_word_then_return_list() throws IOException {
        TextFileReader stopWordReader = new TextFileReader(STOPWORDS_FILE);
        stopWordReader.read();
        List<String> filterList = stopWordReader.getWordsToFilterOut();
        Assertions.assertFalse(filterList.isEmpty());
    }

}
