import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class TextFileReaderTest {

    @Test
    void when_entering_filename_then_text_is_read() throws FileNotFoundException {
        TextFileReader textFileReader = new TextFileReader();
        String text = textFileReader.read("src/test/resources/mytext.txt");
        Assertions.assertEquals("Mary had a little lamb", text);
    }

    @Test
    void when_entering_file_with_multiple_lines_return_single_line() throws FileNotFoundException {
        TextFileReader textFileReader = new TextFileReader();
        String text = textFileReader.read("src/test/resources/mytext_splitted_lines.txt");
        Assertions.assertEquals("Mary had a little lamb", text);
    }

    @Test
    void when_file_is_empty_return_empty_string() throws FileNotFoundException {
        TextFileReader textFileReader = new TextFileReader();
        String text = textFileReader.read("src/test/resources/mytext_empty.txt");
        Assertions.assertEquals("", text);
    }

}
