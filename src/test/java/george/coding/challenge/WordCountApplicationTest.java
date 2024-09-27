package george.coding.challenge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static george.coding.challenge.Constants.MY_TEXT_FILENAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCountApplicationTest {

    private PrintStream backupOut;

    @BeforeEach
    void setUp() {
        backupOut = System.out;
    }

    @Test
    void shouldWordCountIfValidFileNameProvideAsArg() throws IOException {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        // when
        WordCountApplication.main(new String[]{MY_TEXT_FILENAME});

        // then
        var text = outputStream.toString(StandardCharsets.UTF_8);
        assertEquals("Number of words: 4, unique: 4; average word length: 4.25 characters", text.trim());
    }

    @AfterEach
    void tearDown() {
        System.setOut(backupOut);
    }
}