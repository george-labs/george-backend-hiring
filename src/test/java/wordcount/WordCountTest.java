package wordcount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WordCountTest {

    @Test
    void main() {
        InputStream oldInputStream = System.in;
        InputStream inputStream = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(inputStream);

        PrintStream oldOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        WordCount.main(new String[]{});

        assertTrue(outputStreamCaptor.toString().contains("Number of words: 4"));

        System.setIn(oldInputStream);
        System.setOut(oldOut);
    }
}