package sk.erste.wordcountkata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationIT {
    @Test
    public void testMain_inputFile() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        JavaApplication.main(new String[] {"mytext.txt"});

        assertEquals("Number of words: 4, unique: 4; average word length: 4.25 characters\n", baos.toString());
    }

}
