import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TextFileReadingServiceTest {

    @Test
    void when_the_file_with_stop_words_doesnt_exist_then_throw_exception() {
        TextFileReadingService textFileReadingService = new TextFileReadingService();

        Assertions.assertThrows(RuntimeException.class,
                () -> textFileReadingService.readFile("src/test/resources/stopwords-test-not-exists.txt"));

    }

    @Test
    void when_the_file_exist_then_read_text_from_file() {
        TextFileReadingService textFileReadingService = new TextFileReadingService();

        var text = textFileReadingService.readFile("src/test/resources/stopwords-test.txt");

        Assertions.assertNotNull(text);
        Assertions.assertFalse(text.isEmpty());
    }

}