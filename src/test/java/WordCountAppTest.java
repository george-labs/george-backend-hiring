import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WordCountAppTest {

    @Test
    void when_no_argument_then_read_from_console() throws IOException {
        String[] args = {};
        WordCountApp wordCountApp = new WordCountApp(args);
        WordCountApp.RUNNING_TYPE actual = wordCountApp.getRunningType();
        assertEquals(WordCountApp.RUNNING_TYPE.CONSOLE, actual);
    }

    @Test
    void when_file_argument_then_read_from_file() throws IOException {
        String[] args = {"src/test/resources/mytext.txt"};
        WordCountApp wordCountApp = new WordCountApp(args);
        WordCountApp.RUNNING_TYPE actual = wordCountApp.getRunningType();
        assertEquals(WordCountApp.RUNNING_TYPE.FILE, actual);
    }

}