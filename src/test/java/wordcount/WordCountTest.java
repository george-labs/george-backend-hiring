package wordcount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class WordCountTest {

    @Test
    void main() {
        // Capture input
        InputStream oldInputStream = System.in;
        InputStream inputStream = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(inputStream);


        System.setIn(oldInputStream);
    }
}