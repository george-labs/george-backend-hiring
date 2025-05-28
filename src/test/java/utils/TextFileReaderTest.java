package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TextFileReaderTest {

    @Test
    void when_the_file_with_stop_words_doesnt_exist_then_throw_exception() {
        TextFileReader textFileReader = new TextFileReader();

        Assertions.assertThrows(RuntimeException.class,
                () -> textFileReader.readFile("src/test/resources/stopwords-test-not-exists.txt"));

    }

    @Test
    void when_the_file_exist_then_read_text_from_file() {
        TextFileReader textFileReader = new TextFileReader();

        var text = textFileReader.readFile("src/test/resources/stopwords-test.txt");

        Assertions.assertNotNull(text);
        Assertions.assertFalse(text.isEmpty());
    }

}